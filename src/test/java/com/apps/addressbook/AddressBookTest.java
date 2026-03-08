package com.apps.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

public class AddressBookTest {

	AddressBook addressBook;

	@BeforeEach
	void setUp() {
		addressBook = new AddressBook();
	}

	@Test
	void givenMultipleContacts_whenAdded_shouldStoreAllContacts() {

		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact contact2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		Assertions.assertEquals(2, addressBook.getContactList().size());
	}

	@Test
	void givenMultipleContacts_whenStored_shouldMaintainCorrectOrder() {
		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact contact2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		Assertions.assertEquals("Anvesh", addressBook.getContactList().get(0).getFirstName());
		Assertions.assertEquals("Rahul", addressBook.getContactList().get(1).getFirstName());
	}
}