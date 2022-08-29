package com.zohocrm2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm2.entity.Contact;
import com.zohocrm2.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired 
	private ContactRepository contactRepo;
	@Override
	public void saveContact(Contact contact) {
		contactRepo.save(contact);
	}

}
