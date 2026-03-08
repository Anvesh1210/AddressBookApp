package com.apps.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	//contact list
	private List<Contact> contactList;

	//constructor
	public AddressBook() {
		contactList = new ArrayList<>();
	}

	//method to add a contact in contact list
	public void addContact(Contact contact) {
		contactList.add(contact);
		System.out.println("Contact added successfully.");
	}

	//method to display all contact
	public void displayContacts() {
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	//method to get all contact
	public List<Contact> getContactList() {
		return contactList;
	}

}