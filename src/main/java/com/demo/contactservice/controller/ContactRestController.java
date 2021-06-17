package com.demo.contactservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.contactservice.entity.Contact;
import com.demo.contactservice.service.ContactService;
import com.demo.contactservice.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class ContactRestController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listAllUsers() {
		List<Contact> contacts = this.contactService.findContacts();
		if (contacts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getContact(@PathVariable("id") long id) {
		Contact contact = this.contactService.findById(id);
		if (contact == null) {
			return new ResponseEntity<>(new CustomErrorType("Contact with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public ResponseEntity<?> createContact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder) {
		this.contactService.saveOrUpdate(contact);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/contacts/{id}").buildAndExpand(contact.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody Contact contact) {
		Contact currentContact = this.contactService.findById(id);

		if (currentContact == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Contact with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}

		currentContact.setFirstName(contact.getFirstName());
		currentContact.setLastName(contact.getLastName());
		currentContact.setEmail(contact.getEmail());
		currentContact.setPhoneNum(contact.getPhoneNum());
		currentContact.setStatus('I');

		this.contactService.saveOrUpdate(currentContact);
		return new ResponseEntity<Contact>(currentContact, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		Contact contact = this.contactService.findById(id);
		if (contact == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Contact with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		
		this.contactService.deleteContactById(id);
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	}
}