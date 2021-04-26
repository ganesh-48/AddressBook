package com.addressbooksystem;

import java.util.*;
import java.util.stream.Collectors;

/*@Description-Welcome to address book system.
*Create a contact in address book system.
*Add contact details FirstName, lastname,address,city,state,zip,phone number and email.
* Add new contact to address book.
* Manage a relationship between address book and contact person.
* Delete a person details using a person name in address book.
* Add a multiple persons in address book.
* Add one person at a time in address book.
* Refactor to add multiple address book to system.
* Check the no duplicate entry in address book.
* Check same name of persons no duplicate entry into address book.
* Search person by state .
* used dictionary of city and person.
* count  number of person by city or state name
* sort the entries in address book  alphabetically by Person’s name.
* sort the entries in the address book by Person’s city.
* sort the entries in the address book by Person’s state.
* sort the entries in the address book by Person’s zip.*/
public class AddressBook {

    private static List<Contacts> employeeContactsList;
    public AddressBook(List<Contacts> employeeContactsList) {
        this.employeeContactsList = employeeContactsList;
    }

    /* @Description - to write the employee contacts details */
    private static void writeEmployeeContactsData(Scanner consoleInputReader) {
        System.out.println("Enter your first name");
        String firstName = consoleInputReader.nextLine();
        System.out.println("Enter your last name");
        String lastName = consoleInputReader.nextLine();
        System.out.println("Enter your address name");
        String address = consoleInputReader.nextLine();
        System.out.println("Enter your city name");
        String city = consoleInputReader.nextLine();
        System.out.println("Enter your state name");
        String state = consoleInputReader.nextLine();
        System.out.println("Enter your zip  code ");
        int  zip = consoleInputReader.nextInt();
        System.out.println("Enter your zip  code ");
        long  mobileNumber = consoleInputReader.nextLong();
        System.out.println("Enter your email Id");
        String emailId = consoleInputReader.nextLine();

    }

    /* @Description - to read  the employee contacts details */
    private static void readEmployeeContactsData() {
        System.out.println("Write employee contacts details " + employeeContactsList);
    }

    public static void main(String[] args) {
        ArrayList<Contacts> employeePayrollList = new ArrayList<>();
        AddressBook addressBook = new AddressBook(employeeContactsList);
        Scanner consoleInputReader = new Scanner(System.in);
        AddressBook.writeEmployeeContactsData(consoleInputReader);
        AddressBook.readEmployeeContactsData();

    }
}