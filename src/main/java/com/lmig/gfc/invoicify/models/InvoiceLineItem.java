package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

// This needs to be an entity
@Entity
public class InvoiceLineItem {

	// This needs an id
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// This needs a one-to-one relationship to a billing record named "billingRecord"
	@OneToOne()
	private BillingRecord billingRecord;
	
 
	// This needs a many-to-one relationship to a user named "createdBy"
	@ManyToOne()
	private User createdBy;
	
	// This needs a many-to-one relationship to an invoice named "invoice"
	@ManyToOne()
	private Invoice invoice;
	
	// Lots of getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BillingRecord getBillingRecord() {
		return billingRecord;
	}

	public void setBillingRecord(BillingRecord billingRecord) {
		this.billingRecord = billingRecord;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	
	
}

