package com.rentrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentrabbit.model.Invoice;
import com.rentrabbit.serviceImpl.InvoiceServiceImpl;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	InvoiceServiceImpl invoiceService;

	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		List<Invoice> invoices = invoiceService.getAllInvoices();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
		Invoice invoice = invoiceService.getInvoiceById(id);
		if (invoice != null) {
			return new ResponseEntity<>(invoice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
		Invoice createdInvoice = invoiceService.createInvoice(invoice);
		return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice updatedInvoice) {
		Invoice updated = invoiceService.updateInvoice(id, updatedInvoice);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
		invoiceService.deleteInvoice(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
