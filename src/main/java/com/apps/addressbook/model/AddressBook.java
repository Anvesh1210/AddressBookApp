package com.apps.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private String addressBookName;
    private List<Contact> contactList;

    public AddressBook(String addressBookName) {
        this.addressBookName = addressBookName;
        this.contactList = new ArrayList<>();
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void displayContacts() {

        if(contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for(Contact contact : contactList) {
            System.out.println(contact);
        }
    }
}