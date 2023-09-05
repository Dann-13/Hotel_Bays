/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dann-dev
 */
public class Administrator {
    private String Name;
    
    private String UserName;
    private String Email;
    private String Password;
    private String Administrator_type;

    public Administrator(String Name, String UserName, String Email, String Password, String Administrator_type) {
        this.Name = Name;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.Administrator_type = Administrator_type;
    }

    
    public Administrator(String Name, String Email, String UserName, String Administrator_type) {
        this.Name = Name;
        this.Email = Email;
        this.UserName = UserName;
        this.Administrator_type = Administrator_type;
    }
    
    

    public Administrator(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAdministrator_type() {
        return Administrator_type;
    }

    public void setAdministrator_type(String Administrator_type) {
        this.Administrator_type = Administrator_type;
    }

    @Override
    public String toString() {
        return "Administrador{" + "Name=" + Name + ", Email=" + Email + ", UserName=" + UserName + ", Password=" + Password + ", Administrator_type=" + Administrator_type + '}';
    }
    
   

   
}
