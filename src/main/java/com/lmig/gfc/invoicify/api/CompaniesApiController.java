package com.lmig.gfc.invoicify.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/admin/companies")
public class CompaniesApiController {
	
	private CompanyRepository  companyRepository;
	
	public CompaniesApiController(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

 @PostMapping("")
 public Company create(@RequestBody Company company) {
	 
	 return companyRepository.save(company);
 }

}
