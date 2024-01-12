package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Invoice;

public interface InvoiceService {
	List<Invoice> getAllInvoices();

	Invoice getInvoiceById(Long id);

	Invoice createInvoice(Invoice invoice);

	Invoice updateInvoice(Long id, Invoice updatedInvoice);

	void deleteInvoice(Long id);
}
