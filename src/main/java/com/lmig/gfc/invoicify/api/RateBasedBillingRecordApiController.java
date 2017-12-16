package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RequestMapping("/api/billing-records/rate-baseds")
@RestController
public class RateBasedBillingRecordApiController {
	private BillingRecordRepository billingRecordRepository;
	private CompanyRepository companyRepository;
	
	

	public RateBasedBillingRecordApiController(CompanyRepository companyRepository, BillingRecordRepository billingRecordRepository) {
		this.billingRecordRepository = billingRecordRepository;
		this.companyRepository = companyRepository;
		
	}

	@PostMapping("")
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord billingRecord, Authentication auth) {
		User user = (User) auth.getPrincipal();
		billingRecord.setCreatedBy(user);
		billingRecord.setClient(companyRepository.findOne(billingRecord.getClient().getId()));
		return billingRecordRepository.save(billingRecord);
	}

}
