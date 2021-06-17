package com.demo.contactservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.contactservice.entity.Contact;
import com.demo.contactservice.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findContacts() {
		return this.contactRepository.findAll();
	}

	public Contact saveOrUpdate(Contact contact) {
		return this.contactRepository.save(contact);
	}
	
	public Contact findById(long id) {
		return this.contactRepository.findOne(id);
	}
	
	public void deleteContactById(long id) {
		this.contactRepository.delete(id);
	}
}