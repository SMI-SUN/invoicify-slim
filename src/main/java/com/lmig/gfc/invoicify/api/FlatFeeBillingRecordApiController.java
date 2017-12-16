package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;



@RestController
@RequestMapping("/api/billing-records/flat-fees")
public class FlatFeeBillingRecordApiController {
	
	private BillingRecordRepository  billingRecordRepository;
	private CompanyRepository companyRepository;
	
	public FlatFeeBillingRecordApiController(CompanyRepository companyRepository, BillingRecordRepository  billingRecordRepository) {
		this.billingRecordRepository =  billingRecordRepository;
		this.companyRepository = companyRepository;
	}
		
	@PostMapping("")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord billingRecord, Authentication auth) {
		User user = (User) auth.getPrincipal();
		billingRecord.setCreatedBy(user);
		billingRecord.setClient(companyRepository.findOne(billingRecord.getClient().getId()));
		return billingRecordRepository.save(billingRecord);
	}
}
