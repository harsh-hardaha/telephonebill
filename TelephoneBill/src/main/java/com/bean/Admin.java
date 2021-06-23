package com.bean;

public class Admin 
{
    int adminid;

    public int getAdminid() {
        return adminid;
    }

    private void setAdminid(int adminid) {
        this.adminid = adminid;
    }
    String adminuname;
    String adminpwd;
    
    
    public Admin()
    {
        
    }

    public Admin(String adminuname, String adminpwd) {
        this.adminuname = adminuname;
        this.adminpwd = adminpwd;
    }
    

    public String getAdminuname() {
        return adminuname;
    }

    public void setAdminuname(String adminuname) {
        this.adminuname = adminuname;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }
}
