package com.apps.addressbook;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

@SpringBootApplication
public class AddressBookAppApplication {
	public static void main(String[] args) {

		SpringApplication.run(AddressBookAppApplication.class, args);

		AddressBook addressBook = new AddressBook();
		Scanner scanner = new Scanner(System.in);

		String choice;

		do {

			System.out.println("\nEnter Contact Details");

			System.out.println("First Name:");
			String firstName = scanner.nextLine();

			System.out.println("Last Name:");
			String lastName = scanner.nextLine();

			System.out.println("Address:");
			String address = scanner.nextLine();

			System.out.println("City:");
			String city = scanner.nextLine();

			System.out.println("State:");
			String state = scanner.nextLine();

			System.out.println("Zip:");
			String zip = scanner.nextLine();

			System.out.println("Phone:");
			String phone = scanner.nextLine();

			System.out.println("Email:");
			String email = scanner.nextLine();

			Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
			addressBook.addContact(contact);
			System.out.println("\nDo you want to add another contact? (yes/no)");
			choice = scanner.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		System.out.println("\nAll Contacts:");
		addressBook.displayContacts();

		scanner.close();
	}
}
