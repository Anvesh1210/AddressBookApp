package com.apps.addressbook.controller;

import java.util.List;
import java.util.Scanner;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;
import com.apps.addressbook.service.AddressBookManager;

public class AddressBookController {

	private AddressBookManager manager = new AddressBookManager();
	private Scanner scanner = new Scanner(System.in);

	public void start() {
		System.out.println("Enter AddressBook Name:");
		String bookName = scanner.nextLine();
		manager.createAddressBook(bookName);
		AddressBook addressBook = manager.getAddressBook(bookName);
		int choice;
		do {
			System.out.println("\n1.Add Contact");
			System.out.println("2.Edit Contact");
			System.out.println("3.Delete Contact");
			System.out.println("4.Display Contacts");
			System.out.println("0.Exit");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addContact(addressBook);
				break;

			case 2:
				editContact(addressBook);
				break;

			case 3:
				deleteContact(addressBook);
				break;

			case 4:
				addressBook.displayContacts();
				break;
			}

		} while (choice != 0);
	}

	private void addContact(AddressBook addressBook) {

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

		addressBook.getContactList().add(contact);

		System.out.println("Contact added.");
	}

	private void editContact(AddressBook addressBook) {

		System.out.println("Enter first name to edit:");
		String name = scanner.nextLine();

		List<Contact> contacts = addressBook.getContactList();

		for (Contact contact : contacts) {

			if (contact.getFirstName().equalsIgnoreCase(name)) {

				System.out.println("New Address:");
				contact.setAddress(scanner.nextLine());

				System.out.println("New City:");
				contact.setCity(scanner.nextLine());

				System.out.println("New State:");
				contact.setState(scanner.nextLine());

				System.out.println("New Zip:");
				contact.setZip(scanner.nextLine());

				System.out.println("New Phone:");
				contact.setPhoneNumber(scanner.nextLine());

				System.out.println("New Email:");
				contact.setEmail(scanner.nextLine());

				System.out.println("Contact updated.");
				return;
			}
		}

		System.out.println("Contact not found.");
	}

	private void deleteContact(AddressBook addressBook) {
		System.out.println("Enter first name to delete:");
		String name = scanner.nextLine();
		List<Contact> contacts = addressBook.getContactList();
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getFirstName().equalsIgnoreCase(name)) {
				contacts.remove(i);
				System.out.println("Contact deleted.");
				return;
			}
		}
		System.out.println("Contact not found.");
	}
}