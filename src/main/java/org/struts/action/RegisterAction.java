package org.struts.action;

import org.struts.dao.AdminDB;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String username, password, email;
    private int age;
    AdminDB callDB = null;
    
    public String execute() {
        callDB = new AdminDB();
        try {
            callDB.registerUser(username, email, age, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTER";
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
}
