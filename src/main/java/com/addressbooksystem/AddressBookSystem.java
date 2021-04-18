package com.addressbooksystem;

/*@Description-Welcome to address book system.
*Create a contact in address book system.
*Add contact details FirstName, lastname,address,city,state,zip,phone number and email. */
public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to address book system");

        //create a contact in address book 
        Contacts contact = new Contacts("Ram", "Sharma", "Line No-3", "solapur", "maharashtra", 413101, 8767493484L, "abc@gmail.com");
        System.out.println(contact.toString());
    }
}
