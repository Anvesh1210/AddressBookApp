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

			System.out.println("\n===== ADDRESS BOOK MENU =====");
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display Contacts");
			System.out.println("5. Search By City");
			System.out.println("6. Search By State");
			System.out.println("7. View Persons By City (UC9)");
			System.out.println("8. View Persons By State (UC9)");
			System.out.println("0. Exit");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1 -> addContact(addressBook);

			case 2 -> editContact(addressBook);

			case 3 -> deleteContact(addressBook);

			case 4 -> addressBook.displayContacts();

			case 5 -> searchByCity();

			case 6 -> searchByState();

			case 7 -> manager.displayPersonsByCity();

			case 8 -> manager.displayPersonsByState();

			case 0 -> System.out.println("Exiting...");

			default -> System.out.println("Invalid choice");
			}

		} while (choice != 0);
	}

	private void addContact(AddressBook addressBook) {

		System.out.println("First Name:");
		String firstName = scanner.nextLine();

		System.out.println("Last Name:");
		String lastName = scanner.nextLine();

		List<Contact> contacts = addressBook.getContactList();

		boolean duplicate = contacts.stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName)
				&& contact.getLastName().equalsIgnoreCase(lastName));

		if (duplicate) {
			System.out.println("Duplicate contact found. Cannot add.");
			return;
		}

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

		contacts.add(contact);

		System.out.println("Contact added successfully.");
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

	private void searchByCity() {

		System.out.println("Enter city:");

		String city = scanner.nextLine();

		List<Contact> results = manager.searchPersonByCity(city);

		if (results.isEmpty()) {

			System.out.println("No contacts found.");

			return;
		}

		results.forEach(System.out::println);
	}

	private void searchByState() {

		System.out.println("Enter state:");

		String state = scanner.nextLine();

		List<Contact> results = manager.searchPersonByState(state);

		if (results.isEmpty()) {

			System.out.println("No contacts found.");

			return;
		}

		results.forEach(System.out::println);
	}
}