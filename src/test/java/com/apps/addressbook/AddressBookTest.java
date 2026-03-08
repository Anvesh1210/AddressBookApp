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
	void givenContactExists_whenDeleted_shouldRemoveContact() {
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		addressBook.deleteContact("Anvesh");
		Assertions.assertTrue(addressBook.getContactList().isEmpty());
	}

	@Test
	void givenContactNotExists_whenDeleteAttempted_shouldNotChangeList() {
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		int sizeBefore = addressBook.getContactList().size();
		addressBook.deleteContact("Rahul");
		Assertions.assertEquals(sizeBefore, addressBook.getContactList().size());
	}

	@Test
	void givenMultipleContacts_whenOneDeleted_shouldRemoveOnlyThatContact() {
		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact contact2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		addressBook.deleteContact("Anvesh");
		Assertions.assertEquals(1, addressBook.getContactList().size());
	}
}