package com.example.pl;

import android.media.Image;

public class Person {

    private int id;
    private String pimage;
    private String name;
    private String lastName;
    private String nickName;
    private String gName;
    private String workAdd;
    private String homeAdd;
    private String email;
    private String web;
    private String bdate;
    private String mobile;
    private String phoneWork;
    private String phoneHome;
    private String faxWork;
    private String faxHOme;
    private String other;

    public Person(){}
    public Person(int id){
        this.id = id;
    }

    public Person (int id, String pimage, String name, String lastName, String nickName, String gName, String workAdd, String homeAdd, String email, String web, String bdate, String mobile, String phoneWork, String phoneHome, String faxWork, String faxHOme, String other){
        this.id = id;
        PImage(pimage);
        Name(name);
        LastName(lastName);
        NickName(nickName);
        GName(gName);
        WorkAdd(workAdd);
        HomeAdd(homeAdd);
        Email(email);
        Web(web);
        Bdate(bdate);
        Mobile(mobile);
        PhoneWork(phoneWork);
        PhoneHome(phoneHome);
        FaxHOme(faxHOme);
        FaxWork(faxWork);
        Other(other);
    }

    public int Id() {
        return id;
    }

    public String PImage() {
        return this.pimage;
    }

    public void PImage(String image) {
        this.pimage = image;
    }

    public String Name() {
        return name;
    }

    public void Name(String name) {
        this.name = name;
    }

    public String LastName() {
        return lastName;
    }

    public void LastName(String lastName) {
        this.lastName = lastName;
    }

    public String NickName() {
        return nickName;
    }

    public void NickName(String nickName) {
        this.nickName = nickName;
    }

    public String GName() {
        return gName;
    }

    public void GName(String gName) {
        this.gName = gName;
    }

    public String WorkAdd() {
        return workAdd;
    }

    public void WorkAdd(String workAdd) {
        this.workAdd = workAdd;
    }

    public String HomeAdd() {
        return homeAdd;
    }

    public void HomeAdd(String homeAdd) {
        this.homeAdd = homeAdd;
    }

    public String Email() {
        return email;
    }

    public void Email(String email) {
        this.email = email;
    }

    public String Web() {
        return web;
    }

    public void Web(String web) {
        this.web = web;
    }

    public String Bdate() {
        return bdate;
    }

    public void Bdate(String bdate) {
        this.bdate = bdate;
    }

    public String Mobile() {
        return mobile;
    }

    public void Mobile(String mobile) {
        this.mobile = mobile;
    }

    public String PhoneWork() {
        return phoneWork;
    }

    public void PhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String PhoneHome() {
        return phoneHome;
    }

    public void PhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String FaxWork() {
        return faxWork;
    }

    public void FaxWork(String faxWork) {
        this.faxWork = faxWork;
    }

    public String FaxHOme() {
        return faxHOme;
    }

    public void FaxHOme(String faxHOme) {
        this.faxHOme = faxHOme;
    }

    public String Other() {
        return other;
    }

    public void Other(String other) {
        this.other = other;
    }
}
