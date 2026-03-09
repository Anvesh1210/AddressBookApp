package com.apps.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbook.controller.AddressBookController;

@SpringBootApplication
public class AddressBookAppApplication {
	public static void main(String[] args) {

		SpringApplication.run(AddressBookAppApplication.class, args);

		AddressBookController controller = new AddressBookController();
		controller.start();
	}
}
