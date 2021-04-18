package com.addressbooksystem;

import java.util.Scanner;

/*@Description-Welcome to address book system.
*Create a contact in address book system.
*Add contact details FirstName, lastname,address,city,state,zip,phone number and email.
* Add new contact to address book.
* Manage a relationship between address book and contact person. */
public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book system");

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        addressBook.addNewContact();
        System.out.println("Enter the person name who's details want to edit :");
        addressBook.editContact(scanner.next());
        System.out.println(addressBook.toString());
    }

        Contacts contacts;

    /*Add a new contact in a address book.
    * Add person details in this address book.*/
    public void addNewContact() {
            String firstName,lastName,address,city,state,email;
            int zip;
            long mobileNumber;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your first name:");
            firstName = scanner.nextLine();
            System.out.println("Enter the last name :");
            lastName = scanner.nextLine();
            System.out.println("Enter the address :");
            address = scanner.nextLine();
            System.out.println("Enter the city :");
            city = scanner.nextLine();
            System.out.println("Enter the state :");
            state = scanner.nextLine();
            System.out.println("Enter the email :");
            email = scanner.nextLine();
            System.out.println("Enter the zip :");
            zip = scanner.nextInt();
            System.out.println("Enter the mobile number :");
            mobileNumber = scanner.nextLong();

            contacts = new Contacts(firstName, lastName, address, city, state, zip, mobileNumber, email);
            System.out.println("contact added");
        }

    /*Edit contact details in a address book.
    * Using person name edit a contact detail. */
    public void editContact(String firstName) {
        if(contacts == null) {
            System.out.println("Address book is empty");
        } else {
            if(contacts.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Edit the Contact details:");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter first name:");
                contacts.setFirstName(scanner.next());
                System.out.println("Enter last name:");
                contacts.setLastName(scanner.next());
                System.out.println("Enter the address:");
                contacts.setAddress(scanner.next());
                System.out.println("Enter city name:");
                contacts.setCity(scanner.next());
                System.out.println("Enter the state name:");
                contacts.setState(scanner.next());
                System.out.println("Enter the zip code:");
                contacts.setZip(scanner.nextInt());
                System.out.println("Enter the mobile number:");
                contacts.setMobileNumber(scanner.nextLong());
                System.out.println("Enter the email id:");
                contacts.setEmail(scanner.next());

                System.out.println("All contact of person name is updated");
            } else {
                System.out.println("Entered person name is not found in contacts");
            }
        }
    }

    //print contact details
        public String toString() {
            return contacts.toString();
        }
}
