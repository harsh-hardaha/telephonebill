package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterManager;

public class LoginController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        RegisterManager rm = new RegisterManager();
        
        if(rm.Validate(username, password))
        {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/TelephoneBill/Success.jsp");
        }
        else
        {
              response.sendRedirect("/TelephoneBill/Failure.jsp");
        }
        
    }

    
}
