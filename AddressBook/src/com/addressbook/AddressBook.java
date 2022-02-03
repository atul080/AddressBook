/**
 * @uthor: Atul Srivastav
 * @created on: 31-Dec-2021
 * Address Book
 */
package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/*
* Address Book class to perform all the functionalities of address book.
* */
public class AddressBook {
    //instance variable declaration
    private String name;
    public static ArrayList<Contacts> myAddressBook = new ArrayList<Contacts>();
    //making object of Scanner classs
    public static Scanner sc = new Scanner(System.in);

    public AddressBook(String name) {
        this.myAddressBook = new ArrayList<Contacts>();
        this.name = name;
    }


        /**
         * Cheks if address book is not empty.
         * method to display user details from address book
         */
    public static void displayContacts()
    {
        if (myAddressBook.size() > 0)
        {
            for (int i = 0; i < myAddressBook.size(); i++)
            {
                System.out.println("\n"+"FirstName:"+ myAddressBook.get(i).getFirstName() +
                        "\n"+"LastName:"+ myAddressBook.get(i).getLastName() +
                        "\n"+"Address:"+ myAddressBook.get(i).getAddress() +
                        "\n"+"City:"+ myAddressBook.get(i).getCity() +
                        "\n"+"State:"+ myAddressBook.get(i).getState() +
                        "\n"+"Zip:"+ myAddressBook.get(i).getZip() +
                        "\n"+"Phone:"+ myAddressBook.get(i).getPhoneNum() +
                        "\n"+"Email:"+ myAddressBook.get(i).getEmail());
                System.out.println();
            }
        }
        else
        {
            System.out.println("No Records Present.");
        }
    }

    /**
     * menuOptions method to give the choices
     * User need to enter an INT value and press enter.
     * @return option chosen by user
     */
    public static int menuOptions() {
        System.out.println("Select from following: " +
                "\n1- Add Contact" +
                "\n2- Edit Contact" +
                "\n3- Delete Contact" +
                "\n4- View All Contact" +
                "\n5- Quit");
        return sc.nextInt();
    }
    /**
     * method to add a new Contact to Address Book
     * takes all the detail to add.
     * creates a new contact after successfully providing the data.
     */
    public static void addContacts() {
        String firstName, lastName, address, city, state, email,phoneNum;
        int zip;
        //taking inputs from users
        System.out.println("Enter the first name:");
        firstName = sc.next();
        System.out.println("Enter the last name:");
        lastName = sc.next();
        System.out.println("Enter the address:");
        address = sc.next();
        System.out.println("Enter the city:");
        city = sc.next();
        System.out.println("Enter the state:");
        state = sc.next();
        System.out.println("Enter the zipCode:");
        zip = sc.nextInt();
        System.out.println("Enter the email id:");
        email = sc.next();
        System.out.println("Enter the phone number:");
        phoneNum = sc.next();
		boolean check = personExist(""+firstName+lastName);
		Contacts allContacts = new Contacts(firstName, lastName, address, city, state, zip, phoneNum, email);
		myAddressBook.add(allContacts);
		System.out.println("A new contact is created.");
		}

    /**
     * method to edit Contacts in Address Book
     * takes phonr number if Address Book is not empty
     * show menu to edit perticular detail.
     * shows the previous data
     * asks for a new value to update
     * prints a message if updated.
     */
    public static void editContacts()
    {
        if (myAddressBook.size() > 0)
        {
            String num, newVal = "";
            int option = 0,i;
            System.out.println("Enter the phone number to search the person: ");
            num = sc.next();
            for (i = 0; i < myAddressBook.size(); i++)
            {
                if (myAddressBook.get(i).getPhoneNum().equalsIgnoreCase(num))
                {
                    System.out.println("Enter the option to edit: " +
                            "\n1. Address " +
                            "\n2. City " +
                            "\n3. State " +
                            "\n4. Zip " +
                            "\n5. Phone Number " +
                            "\n6. Email" +
                            "\n7. First Name" +
                            "\n8. Last Name");
                    option = sc.nextInt();
                    switch (option)
                    {
                        case 1:
                            System.out.println("Previous address:" + myAddressBook.get(i).getAddress() + "\nEnter new value: ");
                            newVal = sc.next();// get new value
                            myAddressBook.get(i).setAddress(newVal);
                            System.out.println("Address Updated Successfully!!!");
                            break;
                        case 2:
                            System.out.println("Previous City:" + myAddressBook.get(i).getCity() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setCity(newVal);
                            System.out.println("City Updated Successfully!!!");
                            break;
                        case 3:
                            System.out.println("Previous State:" + myAddressBook.get(i).getState() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setState(newVal);
                            System.out.println("State Updated Successfully!!!");
                            break;
                        case 4:
                            System.out.println("Previous Zip Code:" + myAddressBook.get(i).getZip() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setZip(Integer.parseInt(newVal));
                            System.out.println("Zip code Updated Successfully!!!");
                            break;
                        case 5:
                            System.out.println("Previous Phone Num:" + myAddressBook.get(i).getPhoneNum() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setPhoneNum(newVal);
                            System.out.println("Phone Number Updated Successfully!!!");
                            break;
                        case 6:
                            System.out.println("Previous Email:" + myAddressBook.get(i).getEmail() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setEmail(newVal);
                            System.out.println("Email Updated Successfully!!!");
                            break;
                        case 7:
                            System.out.println("Previous First Name:" + myAddressBook.get(i).getFirstName() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setFirstName(newVal);
                            System.out.println("First Name Updated Successfully!!!");
                            break;
                        case 8:
                            System.out.println("Previous Last Name:" + myAddressBook.get(i).getLastName() + "\nEnter new value: ");
                            newVal = sc.next();
                            myAddressBook.get(i).setLastName(newVal);
                            System.out.println("Last Name Updated Successfully!!!");
                            break;
                        default:
                            System.out.println("Invalid Input!!!.");
                    }
                    break;
                }
                else {
                    System.out.println("Cannot find the User!");
                }
            }
        }
        else
        {
         System.out.println("No contacts available.");
        }
    }

    /**
     * delContacts method to delete Contacts from Address Book
     * takes phone num
     * delete Contacts if they exists
     */
    public static void delContacts()
    {
        if (myAddressBook.size() > 0)
        {
            //initializing local variables
            String phone;
            int i;
            int flag=0;
            //taking phone number to checkif user exists.
            System.out.println("Enter the phone number to delete the user: ");
            phone = sc.next();
            for (i = 0; i < myAddressBook.size(); i++)
            {
                //if user exists then deleting it and chaning the value of flag.,
                if (myAddressBook.get(i).getPhoneNum().equalsIgnoreCase(phone)) {
                    myAddressBook.remove(i); // delete AllContacts
                    System.out.println("User has been deleted Successfully!");
                    flag=1;
                }
            }
            //checking flag to know if user exists or not.
            if(flag!=1)
                System.out.println("Cannot find the user!");
        }
        else
        {
            //if no user exists
            System.out.println("No contatcs present. Please add Contacts.");
        }
    }
    //book name getter
    public String getName() {
        return name;
    }

    
    //operations method
    public void operations(AddressBook book) {
        //welcome message
        System.out.println("Welcome to Address Book: " + getName());
        //initializing  variable
        int option;
        //loops until user want to quit.
        while (true) {
            //calling menuOption method which returns the option choosen by the user
            option = menuOptions();
            //calling the methods based on choosen option
            switch (option)
            {
                case 1:
                        addContacts();
                        break;// add Contacts
                case 2:
                        editContacts();
                        break;// edit Contacts
                case 3:
                        delContacts();
                        break;//delete Contacts
                case 4:
                        displayContacts();
                        break;// display All Contacts
                case 5:
                        System.out.println("Thank You! ");
                       return;
                default:
                        System.out.println("Enter a valid entry");
            }
        }
    }
}

