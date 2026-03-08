package com.apps.addressbook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	// contact list
	private List<Contact> contactList;

	// constructor
	public AddressBook() {
		contactList = new ArrayList<>();
	}

	// method to add a contact in contact list
	public void addContact(Contact contact) {
		contactList.add(contact);
		System.out.println("Contact added successfully.");
	}

	// method to display all contact
	public void displayContacts() {
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	// method to get all contact
	public List<Contact> getContactList() {
		return contactList;
	}

	// method to edit contact
	public void editContact(String firstName) {

		Scanner scanner = new Scanner(System.in);

		for (Contact contact : contactList) {

			if (contact.getFirstName().equalsIgnoreCase(firstName)) {

				System.out.println("Contact Found. Enter new details.");

				System.out.println("Enter new Address:");
				contact.setAddress(scanner.nextLine());

				System.out.println("Enter new City:");
				contact.setCity(scanner.nextLine());

				System.out.println("Enter new State:");
				contact.setState(scanner.nextLine());

				System.out.println("Enter new Zip:");
				contact.setZip(scanner.nextLine());

				System.out.println("Enter new Phone:");
				contact.setPhoneNumber(scanner.nextLine());

				System.out.println("Enter new Email:");
				contact.setEmail(scanner.nextLine());

				System.out.println("Contact Updated Successfully");
				return;
			}
		}

		System.out.println("Contact not found");
	}

	// method to delete a contact
	public void deleteContact(String firstName) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				contactList.remove(i);
				System.out.println("Contact deleted successfully.");
				return;
			}
		}
		System.out.println("Contact not found.");
	}
}