<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@ page import="java.util.*,com.bean.*,org.hibernate.*,org.hibernate.cfg.*" %>

<%! int custid;String cname; String username;String address; String phoneno;SessionFactory factory;
    StandardServiceRegistryBuilder sr;Session session1; %>
    
<%!int cid; int billno; int usage;int amt;String dt;%>

<%! String uname; %>
<% uname = session.getAttribute("username").toString();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Details </title>
    </head>
    
   <body align="center" bgcolor="pink">
        <form>
       <center>
            <h1>Telephone Bill Portal</h1>
            </center>
            <p align="right">Welcome <%=uname%>&nbsp;&nbsp;&nbsp;
                <a href = "Logout.jsp">Logout</a>
            </p>
            
            <p align="left">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                <a href="Success.jsp">Home</a></p>

            <h2><center> Pay Bill</h2>
            
        <table align="center" border-spacing = "15px">
            <%
            try
            {
                Configuration cfg = new Configuration();
            
        cfg.configure("hibernate.cfg.xml");
        sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        factory = cfg.buildSessionFactory(sr.build());
        session1 = factory.openSession();
        
        //using from clause
        String S = "select custid from Customer where username='"+uname+"'";
        Query q = session1.createQuery(S);
        Iterator it = q.iterate();
        custid=Integer.parseInt(it.next().toString());
        String SQL_QUERY1 = "from GenerateBill where custid="+custid;
        Query query1 = session1.createQuery(SQL_QUERY1);
        Iterator it1 = query1.iterate();
        GenerateBill gb=(GenerateBill)it1.next();
        amt=gb.getAmount();
        billno=gb.getBillno();
        usage=gb.getCallusage();
        dt="15-06-2021";
        phoneno=gb.getPhoneno();
         %>  
        <tr>
            <td><label>Bill no </label></td><td>:</td>
            <td><label><%=billno%></label></td>
        </tr>
        
        <tr>
            <td><label>Customer id </label></td><td>:</td>
            <td><label><%=custid%></label></td>
        </tr>
        
        <tr>
            <td><label>Phone no</label></td><td>:</td>
            <td><label><%=phoneno%></label></td>
        </tr>
        <tr>
            <td><label>Call usage </label></td><td>:</td>
            <td><label><%=usage%></label></td>
        </tr>
        <tr>
            <td><label>Amount </label></td><td>:</td>
            <td><label>Rs.<%=amt%></label></td>
        </tr>
        <tr>
            <td><label>Paid Date</label></td><td>:</td>
            <td><label> <%=dt%></label></td>
        </tr>
        <%
                    
            }
            catch(Exception e)
            {         
               e.printStackTrace();
            }
            finally
            {
                session1.close();
            }
            
        %>
    </table><br  /></center>
             
    </form>
        </body>
    
</html>
