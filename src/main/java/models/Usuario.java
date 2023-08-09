/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author dan-dev
 */
public class Usuario {
    
    private String Name;
    private String Identity_document;
    private Date Date_of_birth;
    private String Gender;
    private String Address;
    private String City;
    private String Country;
    private String Phone;
    private String Email;
    private String Username;

    public Usuario(String Name, String Identity_document, Date Date_of_birth, String Gender, String Address, String City, String Country, String Phone, String Email, String Username) {
        this.Name = Name;
        this.Identity_document = Identity_document;
        this.Date_of_birth = Date_of_birth;
        this.Gender = Gender;
        this.Address = Address;
        this.City = City;
        this.Country = Country;
        this.Phone = Phone;
        this.Email = Email;
        this.Username = Username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getIdentity_document() {
        return Identity_document;
    }

    public void setIdentity_document(String Identity_document) {
        this.Identity_document = Identity_document;
    }

    public Date getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(Date Date_of_birth) {
        this.Date_of_birth = Date_of_birth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Name=" + Name + ", Identity_document=" + Identity_document + ", Date_of_birth=" + Date_of_birth + ", Gender=" + Gender + ", Address=" + Address + ", City=" + City + ", Country=" + Country + ", Phone=" + Phone + ", Email=" + Email + ", Username=" + Username + '}';
    }
    
}
