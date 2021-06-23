package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterManager;

public class RegisterController extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cname,username, password,address;
        String phoneno;
        PrintWriter out = response.getWriter();
        
        cname = request.getParameter("cname");
        username = request.getParameter("username");
        password = request.getParameter("password");
        address = request.getParameter("address");
        phoneno = request.getParameter("phoneno");
        
        RegisterManager rm = new RegisterManager();
        rm.regCustomer(cname,username,password,address,phoneno);
        out.println("Registered Succesfully");
        
    }

    
}
