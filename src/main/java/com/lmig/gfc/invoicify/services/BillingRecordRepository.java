package com.lmig.gfc.invoicify.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;


public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
	
	public ArrayList<BillingRecord> findByClient(Company client);

}
