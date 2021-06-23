package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.hibernate.cfg.*;

import com.bean.Customer;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RegisterManager 
{
    SessionFactory factory;
    StandardServiceRegistryBuilder sr;

    
    public boolean flag;
    
    public RegisterManager()
    {
        try
        {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            factory = cfg.buildSessionFactory(sr.build());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:: Session not Created");
        }
    }
    
    public void regCustomer(String cname,String username,String password,String address,String phoneno)
    {
        Session session=null;
        Transaction tx=null;
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            Customer rg = new Customer(cname, username,password,address, phoneno);
            session.save(rg);
            
            tx.commit();
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
    }
    
    public boolean Validate(String username,String password)
    {
        Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
   
            List customer = session.createQuery("from Customer").list();
            for(Iterator iterator = customer.iterator(); iterator.hasNext();)
            {
                Customer cust = (Customer) iterator.next();
                
                String uname = cust.getUsername();
                String pwd = cust.getPassword();
               
              if(username.equals(uname)&&password.equals(pwd))
             
                {
                    flag = true;
                    break;
                }
                else
                {
                    flag = false;
                }
            }
                        
            tx.commit();
           
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public void viewProfile()
    {
         Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            Class.forName("org.postgresql.Driver");
            con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from customer");
              
            tx.commit();
            rs.close();
            stmt.close();
            con.close();
            
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
    }
    
   
    
}
