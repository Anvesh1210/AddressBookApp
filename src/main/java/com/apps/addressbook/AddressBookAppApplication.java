package com.apps.addressbook;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

@SpringBootApplication
public class AddressBookAppApplication implements CommandLineRunner {

	private AddressBook addressBook = new AddressBook();

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		System.out.println("Welcome to Address Book Application!!!");
	}

	@Override
	public void run(String... args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter First Name:");
		String firstName = scanner.nextLine();

		System.out.println("Enter Last Name:");
		String lastName = scanner.nextLine();

		System.out.println("Enter Address:");
		String address = scanner.nextLine();

		System.out.println("Enter City:");
		String city = scanner.nextLine();

		System.out.println("Enter State:");
		String state = scanner.nextLine();

		System.out.println("Enter Zip:");
		String zip = scanner.nextLine();

		System.out.println("Enter Phone:");
		String phone = scanner.nextLine();

		System.out.println("Enter Email:");
		String email = scanner.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
		addressBook.addContact(contact);
		addressBook.displayContacts();

		System.out.println("\nEnter First Name of contact to edit:");
		String editName = scanner.nextLine();
		addressBook.editContact(editName);
		System.out.println("\nUpdated Contacts:");
		addressBook.displayContacts();

		System.out.println("\nEnter first name of contact to delete:");
		String nameToDelete = scanner.nextLine();
		addressBook.deleteContact(nameToDelete);
		System.out.println("\nUpdated Contact List:");
		addressBook.displayContacts();
	}
}
