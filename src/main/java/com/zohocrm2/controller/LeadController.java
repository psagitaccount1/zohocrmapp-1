package com.zohocrm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm2.entity.Contact;
import com.zohocrm2.entity.Lead;
import com.zohocrm2.services.ContactService;
import com.zohocrm2.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/savelead")
	public String saveLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	@RequestMapping("/createlead")
	public String convertLead(@RequestParam("id") long id) {
		Lead lead = leadService.getOneLeadById(id);
		Contact  contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		
		contactService.saveContact(contact);
		
		leadService.deleteOneLeadById(id);
		
		return "";
	}
}
