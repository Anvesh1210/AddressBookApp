package com.apps.addressbook.service;

import java.util.HashMap;
import java.util.Map;

import com.apps.addressbook.model.AddressBook;

public class AddressBookManager {

	private Map<String, AddressBook> addressBookMap = new HashMap<>();

	public void createAddressBook(String name) {

		if (addressBookMap.containsKey(name)) {
			System.out.println("AddressBook already exists.");
			return;
		}

		addressBookMap.put(name, new AddressBook(name));
		System.out.println("AddressBook '" + name + "' created.");
	}

	public AddressBook getAddressBook(String name) {
		return addressBookMap.get(name);
	}

	public void showAddressBooks() {

		if (addressBookMap.isEmpty()) {
			System.out.println("No AddressBooks available.");
			return;
		}

		for (String name : addressBookMap.keySet()) {
			System.out.println(name);
		}
	}

	public Map<String, AddressBook> getAddressBookMap() {
		return addressBookMap;
	}
}