package org.struts.model;

public class User {
 
    private String userName;
    private String password;
    private String email;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString() {
        return "Username: " + getUserName() + "\n" + "\nEmail: " + getEmail() + "\nAge: " + getAge() + "\nPassword: " + getPassword();
    }
}
