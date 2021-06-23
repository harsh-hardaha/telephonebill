package com.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BillManager;

import java.io.PrintWriter;

public class GenerateBillController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String duedate;
        int callusage,custid;
        PrintWriter out = response.getWriter();
        //custid = 1;
        custid = Integer.parseInt(request.getParameter("custid"));
        duedate = request.getParameter("duedate");
        callusage = Integer.parseInt(request.getParameter("callusage"));
        
        BillManager am = new BillManager();
        am.generateBill(duedate,callusage,custid);
        out.println("Bill Generated");
        
    }

}
