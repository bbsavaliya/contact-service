package com.demo.contactservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.contactservice.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
}