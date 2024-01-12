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

import com.rentrabbit.model.Discount;
import com.rentrabbit.serviceImpl.DiscountServiceImpl;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

	@Autowired
	DiscountServiceImpl discountService;

	@GetMapping
	public ResponseEntity<List<Discount>> getAllDiscounts() {
		List<Discount> discounts = discountService.getAllDiscounts();
		return new ResponseEntity<>(discounts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
		Discount discount = discountService.getDiscountById(id);
		if (discount != null) {
			return new ResponseEntity<>(discount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
		Discount createdDiscount = discountService.createDiscount(discount);
		return new ResponseEntity<>(createdDiscount, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Discount> updateDiscount(@PathVariable Long id,
			@RequestBody Discount updatedDiscount) {
		Discount updated = discountService.updateDiscount(id, updatedDiscount);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
		discountService.deleteDiscount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
