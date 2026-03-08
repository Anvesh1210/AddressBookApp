package com.apps.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.apps.addressbook.model.Contact;

public class ContactTest {
	@Test
	void givenContactDetails_whenContactObjectCreated_shouldReturnCorrectValues() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		Assertions.assertEquals("Anvesh", contact.getFirstName());
		Assertions.assertEquals("Sahu", contact.getLastName());
		Assertions.assertEquals("Kanpur", contact.getCity());
		Assertions.assertEquals("9876543210", contact.getPhoneNumber());
	}

	@Test
	void givenEmptyConstructor_whenValuesSetUsingSetters_shouldReturnCorrectValues() {

		Contact contact = new Contact();

		contact.setFirstName("Anvesh");
		contact.setLastName("Sahu");
		contact.setCity("Kanpur");

		Assertions.assertEquals("Anvesh", contact.getFirstName());
		Assertions.assertEquals("Sahu", contact.getLastName());
		Assertions.assertEquals("Kanpur", contact.getCity());
	}

	@Test
	void givenTwoContactsWithSameDetails_whenCompared_shouldBeEqual() {

		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		Contact contact2 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		Assertions.assertEquals(contact1, contact2);
	}

	@Test
	void givenTwoContactsWithDifferentDetails_whenCompared_shouldNotBeEqual() {

		Contact contact1 = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		Contact contact2 = new Contact("Rahul", "Sharma", "Indira Nagar", "Lucknow", "UP", "226016", "9999999999",
				"rahul@email.com");

		Assertions.assertNotEquals(contact1, contact2);
	}

	@Test
	void givenContactObject_whenToStringCalled_shouldContainContactDetails() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		String contactString = contact.toString();

		Assertions.assertTrue(contactString.contains("Anvesh"));
		Assertions.assertTrue(contactString.contains("Sahu"));
		Assertions.assertTrue(contactString.contains("Kanpur"));
	}

	@Test
	void givenContactWithNullValues_whenCreated_shouldHandleNullValues() {

		Contact contact = new Contact();

		Assertions.assertNull(contact.getFirstName());
		Assertions.assertNull(contact.getLastName());
	}

	@Test
	void givenContactObject_whenFieldsUpdated_shouldReflectUpdatedValues() {

		Contact contact = new Contact("Anvesh", "Sahu", "Govind Nagar", "Kanpur", "UP", "208006", "9876543210",
				"anvesh@email.com");

		contact.setCity("Lucknow");

		Assertions.assertEquals("Lucknow", contact.getCity());
	}
}
