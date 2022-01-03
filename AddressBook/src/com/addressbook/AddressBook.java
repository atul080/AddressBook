/**
 * @uthor: Atul Srivastav
 * @created on: 31-Dec-2021
 * Address Book
 */
package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

class AllContacts {
	//instance variable declaration
	  public String firstName, lastName, address, city, state, email,phoneNum;
	  public  int zip;


	  //constructor
	  AllContacts(String firstName, String lastName, String address, String city, String state, int zip, String phoneNum, String email)
	  {
	      this.firstName = firstName;
	      this.lastName = lastName;
	      this.address = address;
	      this.city = city;
	      this.state = state;
	      this.zip = zip;
	      this.phoneNum = phoneNum;
	      this.email = email;
	  }
}


public class AddressBooks {
    //main method
    public static void main(String[] args) {
        //welcome message
        System.out.println("Welcome to Address Book Program!!!");
        //initialize variable
        ArrayList<AllContacts> myAddressBook = new ArrayList<AllContacts>();
        Scanner sc=new Scanner(System.in);
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
        //creating contact
        AllContacts allContacts = new AllContacts(firstName, lastName, address, city, state, zip, phoneNum, email);
        myAddressBook.add(allContacts);
        System.out.println("A new contact is created.");
    }
}