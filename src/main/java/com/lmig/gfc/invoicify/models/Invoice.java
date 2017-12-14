package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// This needs to be an entity
@Entity
public class Invoice {
	
	// This needs an id
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// This needs a many-to-one relationship to a company named "company"
	@ManyToOne()
	private Company company;
	
	// This needs a many-to-one relationship to a user named "createdBy"
	@ManyToOne()
	private User createdBy;
	
	// This needs a string named "invoiceNumber"
	private String invoiceNumber;
	
	// This needs a one-to-many relationship for a list of invoice line items mapped by "invoice" with a cascade type of ALL
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL )
	private List<InvoiceLineItem> lineItems;

	// This needs getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public List<InvoiceLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
	

}
