package com.example.employeedatabase;

public class Employees {
    private String FirstName;
    private String LastName;

    Employees(){
        this.LastName = "empty";
        this.FirstName = "empty";
    }


    Employees(String FN, String LN){ // I am running out of names and sanity
        this.FirstName = FN;
        this.LastName = LN;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

}
