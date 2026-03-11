package com.apps.addressbook;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;
import com.apps.addressbook.service.AddressBookManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressBookManagerTest {

	private AddressBookManager manager;

	@BeforeEach
	void setup() {
		manager = new AddressBookManager();
	}

	@Test
	void givenNewContact_whenAdded_shouldIncreaseListSize() {
		AddressBook book = new AddressBook("Family");
		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		book.getContactList().add(contact);
		Assertions.assertEquals(1, book.getContactList().size());
	}

	@Test
	void givenDuplicateContact_whenAdded_shouldNotBeAllowed() {
		AddressBook book = new AddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		book.getContactList().add(c1);
		boolean duplicate = book.getContactList().stream().anyMatch(contact -> contact.equals(c2));
		Assertions.assertTrue(duplicate);
	}

	@Test
	void givenUniqueContacts_whenAdded_shouldStoreBothContacts() {
		AddressBook book = new AddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		book.getContactList().add(c1);
		book.getContactList().add(c2);
		Assertions.assertEquals(2, book.getContactList().size());
	}

	@Test
	void givenSameFirstNameDifferentLastName_whenAdded_shouldBeAllowed() {
		AddressBook book = new AddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Anvesh", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		book.getContactList().add(c1);
		book.getContactList().add(c2);
		Assertions.assertEquals(2, book.getContactList().size());
	}

	@Test
	void givenSameLastNameDifferentFirstName_whenAdded_shouldBeAllowed() {
		AddressBook book = new AddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Rahul", "Sahu", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");
		book.getContactList().add(c1);
		book.getContactList().add(c2);
		Assertions.assertEquals(2, book.getContactList().size());
	}

	@Test
	void givenDuplicateContacts_whenComparedUsingEquals_shouldReturnTrue() {
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Assertions.assertEquals(c1, c2);
	}

	@Test
	void givenContactList_whenStreamSearchDuplicate_shouldDetectDuplicate() {
		AddressBook book = new AddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		Contact c2 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");
		book.getContactList().add(c1);
		boolean exists = book.getContactList().stream().anyMatch(contact -> contact.equals(c2));
		Assertions.assertTrue(exists);
	}
}