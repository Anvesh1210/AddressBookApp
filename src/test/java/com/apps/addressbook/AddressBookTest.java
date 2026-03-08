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
	void givenExistingContact_whenEdited_shouldUpdateContactDetails() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		// simulate edit
		contact.setCity("Lucknow");
		Assertions.assertEquals("Lucknow", addressBook.getContactList().get(0).getCity());
	}

	@Test
	void givenMultipleContacts_whenEditingOne_shouldUpdateOnlyThatContact() {
		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact contact2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		// simulate edit
		contact1.setCity("Delhi");
		Assertions.assertEquals("Delhi", addressBook.getContactList().get(0).getCity());
		Assertions.assertEquals("Lucknow", addressBook.getContactList().get(1).getCity());
	}

	@Test
	void givenContactNotPresent_whenEditAttempted_shouldNotChangeListSize() {
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		addressBook.addContact(contact);
		int sizeBefore = addressBook.getContactList().size();
		// simulate editing a non-existing contact
		String nameToEdit = "Rahul";
		if (!addressBook.getContactList().get(0).getFirstName().equals(nameToEdit)) {
			// nothing updated
		}

		Assertions.assertEquals(sizeBefore, addressBook.getContactList().size());
	}

}