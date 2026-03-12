package com.apps.addressbook;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;
import com.apps.addressbook.service.AddressBookManager;

import java.util.List;
import java.util.Map;

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

	@Test
	void givenMultipleAddressBooks_whenSearchByCity_shouldReturnMatchingContacts() {
		AddressBookManager manager = new AddressBookManager();
		manager.createAddressBook("Family");
		manager.createAddressBook("Friends");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"a@mail.com");
		Contact c2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Kanpur", "UP", "226016", "9999999999",
				"b@mail.com");
		manager.getAddressBook("Family").getContactList().add(c1);
		manager.getAddressBook("Friends").getContactList().add(c2);
		List<Contact> results = manager.searchPersonByCity("Kanpur");
		Assertions.assertEquals(2, results.size());
	}

	@Test
	void givenContacts_whenSearchByState_shouldReturnCorrectContacts() {
		AddressBookManager manager = new AddressBookManager();
		manager.createAddressBook("Office");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"a@mail.com");
		manager.getAddressBook("Office").getContactList().add(c1);
		List<Contact> results = manager.searchPersonByState("UP");
		Assertions.assertEquals(1, results.size());
	}

	@Test
	void givenNoMatchingCity_whenSearch_shouldReturnEmptyList() {
		AddressBookManager manager = new AddressBookManager();
		List<Contact> results = manager.searchPersonByCity("Delhi");
		Assertions.assertTrue(results.isEmpty());
	}

	@Test
	void givenMultipleContacts_whenGroupedByCity_shouldReturnCorrectMap() {
		manager.createAddressBook("Family");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"a@mail.com");
		Contact c2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Kanpur", "UP", "226016", "9999999999",
				"b@mail.com");
		Contact c3 = new Contact("Aman", "Verma", "Sector 10", "Delhi", "DL", "110001", "8888888888", "c@mail.com");
		manager.getAddressBook("Family").getContactList().add(c1);
		manager.getAddressBook("Family").getContactList().add(c2);
		manager.getAddressBook("Family").getContactList().add(c3);
		Map<String, List<Contact>> result = manager.getPersonsByCity();
		Assertions.assertEquals(2, result.get("Kanpur").size());
		Assertions.assertEquals(1, result.get("Delhi").size());
	}

	@Test
	void givenMultipleContacts_whenGroupedByState_shouldReturnCorrectMap() {
		manager.createAddressBook("Office");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"a@mail.com");
		Contact c2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"b@mail.com");
		Contact c3 = new Contact("Aman", "Verma", "Sector 10", "Delhi", "DL", "110001", "8888888888", "c@mail.com");
		manager.getAddressBook("Office").getContactList().add(c1);
		manager.getAddressBook("Office").getContactList().add(c2);
		manager.getAddressBook("Office").getContactList().add(c3);
		Map<String, List<Contact>> result = manager.getPersonsByState();
		Assertions.assertEquals(2, result.get("UP").size());
		Assertions.assertEquals(1, result.get("DL").size());
	}

	@Test
	void givenMultipleAddressBooks_whenGroupedByCity_shouldIncludeAllContacts() {
		manager.createAddressBook("Family");
		manager.createAddressBook("Friends");
		Contact c1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"a@mail.com");
		Contact c2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Kanpur", "UP", "226016", "9999999999",
				"b@mail.com");
		manager.getAddressBook("Family").getContactList().add(c1);
		manager.getAddressBook("Friends").getContactList().add(c2);
		Map<String, List<Contact>> result = manager.getPersonsByCity();
		Assertions.assertEquals(2, result.get("Kanpur").size());
	}

	@Test
	void givenEmptyAddressBook_whenGroupedByCity_shouldReturnEmptyMap() {
		manager.createAddressBook("Empty");
		Map<String, List<Contact>> result = manager.getPersonsByCity();
		Assertions.assertTrue(result.isEmpty());
	}
}