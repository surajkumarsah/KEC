package com.example.KEC.Model;

public class Faculties
{
    String name;
    String phone;
    String password;
    String branch;
    String qualification;
    String yr_of_experience;

    Faculties()
    {

    }

    Faculties(String name,String phone,String password)
    {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getYr_of_experience() {
        return yr_of_experience;
    }

    public void setYr_of_experience(String yr_of_experience) {
        this.yr_of_experience = yr_of_experience;
    }





}
