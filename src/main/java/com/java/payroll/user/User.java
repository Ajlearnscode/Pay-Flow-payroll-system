/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.payroll.user;

public class User {

    //attributes
    //Important Credentials
    private String userId;
    private String fullName;
    private String password;
    private String email;
    //Address
    private String trn;
    private String country;
    private String street;
    private String city;
    private String parish;
    private String gender;
    //Date of birth
    private int day;
    private int month;
    private int year;

    //Default Constructor
    public User() {
        this.userId = "";
        this.fullName = "";
        this.email = "";
        this.trn = "";
        this.country = "";
        this.street = "";
        this.city = "";
        this.parish = "";
        this.gender = "";
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    //Primary Cpnstructor 1 - Full Sign Up
    public User(String userId, String fullName, String email, String trn, String country, String street, String city, String parish, String gender, int day, int month, int year) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.trn = trn;
        this.country = country;
        this.street = street;
        this.city = city;
        this.parish = parish;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Primary Constructor 2 - Existing user sign up
    public User(String userId, String fullName, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
    }

    //Copy Constructor
    public User(User usr) {
        this.userId = usr.userId;
        this.fullName = usr.fullName;
        this.password = usr.password;
    }

    //Setters and Getters
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrn() {
        return this.trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getParish() {
        return this.parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullName=" + fullName + ", password=" + password + ", email=" + email + ", trn=" + trn + ", country=" + country + ", street=" + street + ", city=" + city + ", parish=" + parish + ", gender=" + gender + ", day=" + day + ", month=" + month + ", year=" + year + '}';
    }

}
