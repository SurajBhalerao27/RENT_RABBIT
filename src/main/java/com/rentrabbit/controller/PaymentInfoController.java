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

import com.rentrabbit.model.PaymentInfo;
import com.rentrabbit.serviceImpl.PaymentInfoServiceImpl;

@RestController
@RequestMapping("/paymentinfos")
public class PaymentInfoController {

	@Autowired
	PaymentInfoServiceImpl paymentInfoService;

	@GetMapping
	public ResponseEntity<List<PaymentInfo>> getAllPaymentInfos() {
		List<PaymentInfo> paymentInfos = paymentInfoService.getAllPaymentInfo();
		return new ResponseEntity<>(paymentInfos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentInfo> getPaymentInfoById(@PathVariable Long id) {
		PaymentInfo paymentInfo = paymentInfoService.getPaymentInfoById(id);
		if (paymentInfo != null) {
			return new ResponseEntity<>(paymentInfo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<PaymentInfo> createPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
		PaymentInfo createdPaymentInfo = paymentInfoService.createPaymentInfo(paymentInfo);
		return new ResponseEntity<>(createdPaymentInfo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PaymentInfo> updatePaymentInfo(@PathVariable Long id,
			@RequestBody PaymentInfo updatedPaymentInfo) {
		PaymentInfo updated = paymentInfoService.updatePaymentInfo(id, updatedPaymentInfo);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePaymentInfo(@PathVariable Long id) {
		paymentInfoService.deletePaymentInfo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
