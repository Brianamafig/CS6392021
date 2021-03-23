package com.example.employeedatabase;

public class Employees {
    private String FirstName;
    private String LastName;


    Employees(String FN, String LN){ // I am running out of names and sanity
        this.FirstName = FN;
        this.LastName = LN;
    }

    public String EmFirstname() {
        return FirstName;
    }

    public String EmLastName() {
        return LastName;
    }
}
