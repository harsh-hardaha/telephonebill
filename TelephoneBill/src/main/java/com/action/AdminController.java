package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminManager;


public class AdminController extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
        String adminuname = request.getParameter("adminuname");
        String adminpwd = request.getParameter("adminpwd");
        
        AdminManager am = new AdminManager();
        
        if(am.Validate(adminuname, adminpwd))
        {
            request.getSession().setAttribute("username", adminuname);
            response.sendRedirect("/TelephoneBill/adminSuccess.jsp");
        }
        else
        {
              response.sendRedirect("/TelephoneBill/Failure.jsp");
        }
        
    }

}
