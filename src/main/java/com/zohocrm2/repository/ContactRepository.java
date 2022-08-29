package com.zohocrm2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm2.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
