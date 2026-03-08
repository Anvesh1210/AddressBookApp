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
	void givenContactDetails_whenContactAdded_shouldIncreaseListSize() {
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		Assertions.assertEquals(1, addressBook.getContactList().size());
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
	void givenContactAdded_whenRetrieved_shouldMatchStoredContact() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		Contact storedContact = addressBook.getContactList().get(0);
		Assertions.assertEquals("Anvesh", storedContact.getFirstName());
		Assertions.assertEquals("Kanpur", storedContact.getCity());
	}

	@Test
	void givenAddressBook_whenInitialized_shouldStartWithEmptyList() {
		Assertions.assertTrue(addressBook.getContactList().isEmpty());
	}

	@Test
	void givenContactAdded_whenCheckingList_shouldNotBeEmpty() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		Assertions.assertFalse(addressBook.getContactList().isEmpty());
	}

	@Test
	void givenContactsAdded_whenDisplayContactsCalled_shouldExecuteWithoutException() {
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		Assertions.assertDoesNotThrow(() -> addressBook.displayContacts());
	}
}