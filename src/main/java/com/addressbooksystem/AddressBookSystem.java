package com.addressbooksystem;

import java.util.*;

public class AddressBookSystem {
    public HashMap<Integer, Contacts> contacts = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    HashMap<String, AddressBook> addressBookSystem = new HashMap<String, AddressBook>();

    /*
     * @description- to add multiple address book in the system and also checking
     * for unique names of the address book
     * @Parameters- passing address book name given by user to create the address
     * book with that name
     */
    public void addAddressBook(String addressBookName) {
        if (addressBookSystem.containsKey(addressBookName)) {
            System.out.println("Address Book : " + addressBookName + " already exist");
        } else {
            AddressBook addressBook = new AddressBook();
            addressBookSystem.put(addressBookName, addressBook);
            System.out.println("address book successfully added to address book system");
        }
    }

    /*
     * @Description- delete a address book of a particular name given by user so
     * searching the map with the address book name and also checking whether the
     * address book system is empty or not
     *
     * @parameters- passing address book name given by user to delete that address
     * book
     */
    public void deleteAddressBook(String addressBookName) {
        if (addressBookSystem.isEmpty())
            System.out.println("Address Book System has no address book in it");
        else {
            if (addressBookSystem.containsKey(addressBookName)) {
                AddressBook addressBook = addressBookSystem.get(addressBookName);
                addressBook.deleteAddressBook();
                addressBookSystem.remove(addressBookName);
                System.out.println("address book : " + addressBookName + " is deleted");
            } else
                System.out.println("address book : " + addressBookName + " is not found");
        }
    }

    public void searchPersonsByCity(String city) {
        System.out.println("Enter the city to search person.");
        String cityName = scanner.next();
        System.out.println("Person Search by " + cityName);
        Collection<Contacts> values = contacts.values();
        ArrayList<Contacts> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithCity = new Hashtable();
        conatactlist.stream().filter(n -> n.city.contains(cityName)).forEach(contactlist -> dictWithCity.put(contactlist.firstName, cityName));
        for (Enumeration i = dictWithCity.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    public void searchPersonsByState(String state) {
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

    /*
     * @Description- Features to access the contacts inside the address book and
     * using case in loop so that user can enter its choices to add, delete, edit or
     * print the contact in address book
     *
     * @Parameter- address book name
     */
    public void accessAddressBook(String addressBookName) {
        if (addressBookSystem.containsKey(addressBookName)) {
            System.out.println("Welcome to Address book : " + addressBookName);
            AddressBook addressBook = addressBookSystem.get(addressBookName);
            int choice = 0;
            while (choice != 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("what you want to do please select accordingly");
                System.out.println("press 1 -> To add a new contact in the address book");
                System.out.println("press 2 -> To edit the existing contact");
                System.out.println("press 3 -> To delete the existing contact");
                System.out.println("press 4 -> To print the Address Book");
                System.out.println("press 5 -> To search person by city");
                System.out.println("press 6 -> To search person by state");
                System.out.println("press 7 -> To count person by city");
                System.out.println("press 8 -> To count person by state");
                System.out.println("press 9 -> sort");
                System.out.println("press 10 -> To exit");

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("enter the first name of contact you want to add");
                        String firstName = scanner.next();
                        addressBook.addNewContact();
                        break;
                    case 2:
                        System.out.println("enter the first name of contact you want to edit");
                        addressBook.editContact(scanner.next());
                        break;
                    case 3:
                        System.out.println("enter the first name of contact you want to delete");
                        addressBook.deleteContact(scanner.next());
                        break;
                    case 4:
                        System.out.println("Search a Address book");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Search a person by city");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 6:
                        System.out.println("Search a person by state");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 7:
                        System.out.println("count person by city");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 8:
                        System.out.println("count person by state");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 9:
                        System.out.println("sort a person");
                        addressBook.searchPersonByCity(scanner.next());
                        break;
                    case 10:
                        System.out.println("sort a person City");
                        addressBook.sortPersonByCity(scanner.next());
                        break;
                    case 11:
                        System.out.println("sort a person state");
                        addressBook.sortPersonByState(scanner.next());
                        break;
                    case 12:
                        System.out.println("sort a person by zip");
                        addressBook.sortPersonByZip(scanner.next());
                        break;
                    case 13:
                        break;
                    default:
                        System.out.println("press correct choice number");
                }
            }

        } else
            System.out.println("Address book : " + addressBookName + " is not found");

    }

    /*
     * @Description- Printing the names of the address books in the address book
     * system
     */
    @Override
    public String toString() {
        if (addressBookSystem.isEmpty())
            return "Address book system is empty";
        else {
            System.out.println("printing address books in the system");
            Iterator iterator = addressBookSystem.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, AddressBook> mapElements = (Map.Entry) iterator.next();
                System.out.println("Address Book Name -> " + mapElements.getKey());
            }
        }
        return "";
    }

    /*
     * @Description- Features to access the address books inside the address book
     * system and using case in loop so that user can enter its choices to add,
     * delete,access and print the address book in address book system
     */
    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        System.out.println("Welcome to Address Book System");
        int choice = 0;
        while (choice != 7) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice");
            System.out.println("Enter 1 : Add  new contact");
            System.out.println("Enter 2 : Edit contact");
            System.out.println("Enter 3 : Delete contact");
            System.out.println("Enter 4 : Print the Address Book");
            System.out.println("Enter 5 : search person by city");
            System.out.println("Enter 6 : search person by state");
            System.out.println("Enter 7 : Exit");
            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("enter the name for your new address book");
                    String newAddressBookName = scanner.next();
                    addressBookSystem.addAddressBook(newAddressBookName);
                    break;
                case 2:
                    System.out.println("enter the name of address book you want to delete");
                    addressBookSystem.deleteAddressBook(scanner.next());
                    break;
                case 3:
                    System.out.println("enter the name of address book you want to access");
                    addressBookSystem.accessAddressBook(scanner.next());
                    break;
                case 4:
                    System.out.println(addressBookSystem.toString());
                    break;

                case 5:
                    System.out.println("enter the city to which your persons belongs");
                    String city = scanner.next();
                    addressBookSystem.searchPersonsByCity(city);
                    break;
                case 6:
                    System.out.println("enter the state to which your persons belongs");
                    String state = scanner.next();
                    addressBookSystem.searchPersonsByState(state);
                    break;
                case 7:
                    System.exit(choice);
                    break;
                default:
                    System.out.println("press correct choice number");
            }
        }

    }
}
