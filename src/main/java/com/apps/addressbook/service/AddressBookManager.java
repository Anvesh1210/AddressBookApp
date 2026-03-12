package com.apps.addressbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

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

	public Map<String, AddressBook> getAddressBookMap() {

		return addressBookMap;
	}

	public List<Contact> searchPersonByCity(String city) {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.filter(contact -> contact.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	public List<Contact> searchPersonByState(String state) {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.filter(contact -> contact.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}

	// UC9

	public Map<String, List<Contact>> getPersonsByCity() {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.collect(Collectors.groupingBy(Contact::getCity));
	}

	public Map<String, List<Contact>> getPersonsByState() {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.collect(Collectors.groupingBy(Contact::getState));
	}

	public void displayPersonsByCity() {

		Map<String, List<Contact>> personsByCity = getPersonsByCity();

		personsByCity.forEach((city, contacts) -> {

			System.out.println("\nCity: " + city);

			contacts.forEach(System.out::println);
		});
	}

	public void displayPersonsByState() {

		Map<String, List<Contact>> personsByState = getPersonsByState();

		personsByState.forEach((state, contacts) -> {

			System.out.println("\nState: " + state);

			contacts.forEach(System.out::println);
		});
	}
}