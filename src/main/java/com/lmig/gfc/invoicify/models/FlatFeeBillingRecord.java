package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

// This needs to be an entity
@Entity
public class FlatFeeBillingRecord extends BillingRecord {

	// This does NOT need an id because it inherits it from the BillingRecord class
	
	// This needs a double field named amount
	private double amount;

	// This needs to override the getTotal() method and return the amount
	
	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return amount;
	}
	
	// This needs getters and setters

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	


	
}
