package com.dao;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.bean.Admin;

public class AdminManager 
{
    SessionFactory factory;
    StandardServiceRegistryBuilder sr;
    public boolean flag = false;
    
     public AdminManager()
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
    
      public boolean Validate(String adminuname,String adminpwd)
    {
        Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            List admin = session.createQuery("from Admin").list();
            for(Iterator iterator = admin.iterator(); iterator.hasNext();)
            {
                Admin ad = (Admin) iterator.next();
                
                String uname = ad.getAdminuname();
                String pwd = ad.getAdminpwd();
                if(adminuname.equals(uname)&&adminpwd.equals(pwd))
             //  if((username.equals("mini"))&& (password.equals("bhar")))
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
     
}
