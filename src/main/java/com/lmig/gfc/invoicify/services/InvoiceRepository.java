package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.Invoice;



public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
