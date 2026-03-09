package com.apps.addressbook;

import com.apps.addressbook.model.AddressBook;
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
	void givenAddressBookName_whenCreated_shouldStoreInMap() {
		manager.createAddressBook("Family");
		Assertions.assertTrue(manager.getAddressBook("Family") != null);
	}

	@Test
	void givenMultipleAddressBooks_whenCreated_shouldStoreAllBooks() {
		manager.createAddressBook("Family");
		manager.createAddressBook("Friends");
		Assertions.assertEquals(2, manager.getAddressBookMap().size());
	}

	@Test
	void givenDuplicateAddressBookName_whenCreated_shouldNotIncreaseMapSize() {
		manager.createAddressBook("Family");
		manager.createAddressBook("Family");
		Assertions.assertEquals(1, manager.getAddressBookMap().size());
	}

	@Test
	void givenAddressBookExists_whenFetched_shouldReturnCorrectObject() {
		manager.createAddressBook("Office");
		AddressBook book = manager.getAddressBook("Office");
		Assertions.assertEquals("Office", book.getAddressBookName());
	}

	@Test
	void givenAddressBookDoesNotExist_whenFetched_shouldReturnNull() {
		AddressBook book = manager.getAddressBook("Unknown");
		Assertions.assertNull(book);
	}

	@Test
	void givenAddressBookCreated_whenCheckedMap_shouldContainKey() {
		manager.createAddressBook("Friends");
		Assertions.assertTrue(manager.getAddressBookMap().containsKey("Friends"));
	}

	@Test
	void givenMultipleAddressBooks_whenStored_shouldMaintainCorrectMapSize() {
		manager.createAddressBook("Family");
		manager.createAddressBook("Friends");
		manager.createAddressBook("Office");
		Assertions.assertEquals(3, manager.getAddressBookMap().size());
	}
}