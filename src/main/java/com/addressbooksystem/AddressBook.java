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
* sort the entries in address book  alphabetically by Person’s name.*/
public class AddressBook {

    //instance variable creating multiple contacts
    String addressBookName;
    ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
    public HashMap<Integer, Contacts> contacts = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    /*Add a new contact in a address book.
    * Add person details in this address book.*/
    public void addNewContact() {
        String firstName, lastName, address, city, state, email;
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

        Contacts contacts = new Contacts(firstName, lastName, address, city, state, zip, mobileNumber, email);
        System.out.println("contact added");
        contactsList.add(contacts);

        }

    /*Check the no duplicate entry in address book.
    * Check same name of persons no duplicate entry into address book. */
    public boolean duplicateEntryCheck(String firstName) {
        for (Contacts contacts : contactsList) {
            boolean existAlready = contacts.equals(firstName);
            if (existAlready == true)
                return true;
        }
        return false;
    }

    /*Edit contact details in a address book.
    * Using person name edit a contact detail.
    * Add one person at time.*/
    public void editContact(String firstName) {
        if (contactsList.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            int p = contactsList.size();
            int i;
            for (i = 0; i < contactsList.size(); i++) {
                if (contactsList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                    System.out.println("you want edit details");
                    System.out.println("Enter 1 : Edit first name");
                    System.out.println("Enter 2 : Edit last name ");
                    System.out.println("Enter 3 : Edit address ");
                    System.out.println("Enter 4 : Edit city name ");
                    System.out.println("Enter 5 : Edit state name ");
                    System.out.println("Enter 6 : Edit zip code ");
                    System.out.println("Enter 7 : Edit mobile number ");
                    System.out.println("Enter 8 : Edit email ID");
                    System.out.println("Enter your choice");
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter first name : ");
                            contactsList.get(i).setFirstName(scanner.next());
                            System.out.println("contact updated");
                            break;

                        case 2:
                            System.out.println("Enter your last name : ");
                            contactsList.get(i).setLastName(scanner.next());
                            System.out.println("contact updated");
                            break;

                        case 3:
                            System.out.println("Enter your address : ");
                            contactsList.get(i).setAddress(scanner.next());
                            System.out.println("contact updated");
                            break;

                        case 4:
                            System.out.println("Enter your city : ");
                            contactsList.get(i).setCity(scanner.next());
                            System.out.println("contact updated");
                            break;

                        case 5:
                            System.out.println("Enter your state  : ");
                            contactsList.get(i).setState(scanner.next());
                            System.out.println("contact updated");
                            break;

                        case 6:
                            System.out.println("Enter your zip : ");
                            contactsList.get(i).setZip(scanner.nextInt());
                            System.out.println("contact updated");
                            break;

                        case 7:
                            System.out.println("Enter your mobile number : ");
                            contactsList.get(i).setMobileNumber(scanner.nextLong());
                            System.out.println("contact updated");
                            break;

                        case 8:
                            System.out.println("Enter your email Id : ");
                            contactsList.get(i).setEmail(scanner.next());
                            System.out.println("contact updated");
                            break;

                        default:
                            System.out.println("Enter right choice ");
                            break;
                    }
                    break;
                }
            }
            if (p == i) {
                System.out.println("Contact not found");
            }
        }
    }

    /*Delete the persons details in address book.
    *Delete the person details using persons name*/
    public void deleteContact(String firstName) {
        if (contactsList.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            int p = contactsList.size();
            int i;
            for (i = 0; i < contactsList.size(); i++) {
                if (contactsList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                    Contacts contact = contactsList.get(i);
                    contact = null;
                    System.out.println("Entered person name Contact is deleted from address book");
                    break;
                }
            }
            if (p == i) {
                System.out.println("Entered contact is not fount address book");
            }
        }
    }

    //print contact details
    public String toString() {
        if (contactsList.isEmpty())
            return "Address book is empty";
        else {
            for (int i = 0; i < contactsList.size(); i++) {
                System.out.println(i + 1 + ". " + contactsList.get(i).toString());
            }
        }
        return "";
    }

    //Delete all the contact from AddressBook
    public void deleteAddressBook() {
        if (!contactsList.isEmpty()) {
            for (int i = 0; i < contactsList.size(); i++) {
                Contacts contact = contactsList.get(i);
                contact = null;
                contactsList.remove(i);
            }
        }
    }
    /*Search person by city.
     * used dictionary of city and person.*/
    public void searchPersonByCity(String city) {
        System.out.println("show person by city in " + addressBookName);
        if (!contactsList.isEmpty()) {
            for (int i = 0; i < contactsList.size(); i++) {
                Contacts contact = contactsList.get(i);
                if (contact.getCity() == city) {
                    System.out.println(i + 1 + "." + contact.getFirstName().toString());
                }
            }
        }
    }

    /*Search person by state .
    * used dictionary of state and person.*/
    public void searchPersonByState(String state) {
        String stateName = scanner.next();
        System.out.println("Person Search by " + stateName);
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithState = new Hashtable();
        conatactlist.stream().filter(n -> n.state.contains(stateName)).forEach(contactlist -> dictWithState.put(contactlist.firstName, stateName));
        for (Enumeration i = dictWithState.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    /*  count  person by city name */
    public void countPersonByCity() {
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contacts C) -> C.getCity(),Collectors.counting())));
    }

    /* count  person by state name */
    public void countPersonByState() {
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contacts C) -> C.getState(),Collectors.counting())));
    }

    /*sort the entries in address book  alphabetically by Person’s name*/
    public void sortPersonByFirstname(){
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (Contacts cont : conatactlist){
            System.out.println(cont.getFirstName() + cont.getLastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(Contacts::getFirstName));
        conatactlist.forEach((Contacts cont) -> System.out.println(cont.getFirstName() + " " + cont.getLastName()));
    }
}