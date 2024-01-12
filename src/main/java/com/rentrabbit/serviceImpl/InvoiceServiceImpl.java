package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.Invoice;
import com.rentrabbit.repository.InvoiceRepository;
import com.rentrabbit.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private final InvoiceRepository invoiceRepository;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
		return optionalInvoice.orElse(null);
	}

	public Invoice createInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
		Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
		if (optionalInvoice.isPresent()) {
			Invoice existingInvoice = optionalInvoice.get();
			// Update fields based on your requirements
			existingInvoice.setAmount(updatedInvoice.getAmount());
//			existingInvoice.setDueDate(updatedInvoice.getDueDate());
			// Update other fields as needed
			return invoiceRepository.save(existingInvoice);
		}
		return null; // Invoice with the given id not found
	}

	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}
}
