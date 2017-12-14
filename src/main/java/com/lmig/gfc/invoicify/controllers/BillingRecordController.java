package com.lmig.gfc.invoicify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {

	// private company repo
	private CompanyRepository companyRepository;

	// private billing record repo
	private  BillingRecordRepository billingRecordRepository;

	// constructor that has both
	public BillingRecordController(CompanyRepository companyRepository,
			BillingRecordRepository billingRecordRepository) {
		this.companyRepository = companyRepository;
		this.billingRecordRepository = billingRecordRepository;
	}
	
	
	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("billing-records/list");

		// Get all the billing records and add them to the model and view with the key "records"
		List<BillingRecord> billingRecords = billingRecordRepository.findAll();
		mv.addObject("records", billingRecords);
		
		// Get all the companies and add them to the model and view with the key "companies"
		List<Company> companies = companyRepository.findAll();
		mv.addObject("companies", companies);
		
		return mv;
	}

}


 