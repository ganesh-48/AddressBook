package com.addressbooksystem;

public class Contacts {
    public String firstName;
    private String lastName;
    private String address;
    public String city;
    public String state;
    private int zip;
    private long mobileNumber;
    private String email;

    public Contacts(String firstName, String lastName, String address, String city, String state, int zip, long mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + ":" + this.mobileNumber + ", " + this.email +  " "
                + " address:" + this.address + ", state:" + this.state + ", city:" + this.city + ", zipCode:"
                + this.zip;
    }


    public void put(int indexValue, Contacts contacts) {
    }
}
