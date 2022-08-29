package com.zohocrm2.services;

import com.zohocrm2.entity.Lead;

public interface LeadService {
	public void saveOneLead(Lead lead);

	public Lead getOneLeadById(long id);

	public void deleteOneLeadById(long id);
}
