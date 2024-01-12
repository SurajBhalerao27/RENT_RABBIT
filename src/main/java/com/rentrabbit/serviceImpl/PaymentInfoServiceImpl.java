package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentrabbit.model.PaymentInfo;
import com.rentrabbit.repository.PaymentInfoRepository;
import com.rentrabbit.service.PaymentInfoService;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Override
	public List<PaymentInfo> getAllPaymentInfo() {
		return paymentInfoRepository.findAll();
	}

	@Override
	public PaymentInfo getPaymentInfoById(Long id) {
		Optional<PaymentInfo> paymentInfoOptional = paymentInfoRepository.findById(id);
		return paymentInfoOptional.orElse(null);
	}

	@Override
	public PaymentInfo createPaymentInfo(PaymentInfo paymentInfo) {
//		if (isPaymentInfoValid(paymentInfo)) {
		return paymentInfoRepository.save(paymentInfo);
//		} else {
//			throw new IllegalArgumentException("Invalid payment information");
//		}
	}

	@Override
	public PaymentInfo updatePaymentInfo(Long id, PaymentInfo updatedPaymentInfo) {
		Optional<PaymentInfo> existingPaymentInfoOptional = paymentInfoRepository.findById(id);

		if (existingPaymentInfoOptional.isPresent()) {
			PaymentInfo existingPaymentInfo = existingPaymentInfoOptional.get();
			if (isPaymentInfoValid(updatedPaymentInfo)) {
				existingPaymentInfo.setCardNumber(updatedPaymentInfo.getCardNumber());
				existingPaymentInfo.setExpirationDate(updatedPaymentInfo.getExpirationDate());
				existingPaymentInfo.setCvv(updatedPaymentInfo.getCvv());

				return paymentInfoRepository.save(existingPaymentInfo);
			} else {

				throw new IllegalArgumentException("Invalid payment information");
			}
		} else {

			throw new IllegalArgumentException("Payment information not found");
		}
	}

	@Override
	public void deletePaymentInfo(Long id) {
		paymentInfoRepository.deleteById(id);
	}

	private boolean isPaymentInfoValid(PaymentInfo paymentInfo) {

		return isValidCardNumber(paymentInfo.getCardNumber()) 
				&& isValidExpirationDate(paymentInfo.getExpirationDate())
				&& isValidCvv(paymentInfo.getCvv());
	}

	private boolean isValidCardNumber(String cardNumber) {

		return cardNumber != null && cardNumber.matches("\\d{16}");
	}

	private boolean isValidExpirationDate(String expirationDate) {

		if (expirationDate != null && expirationDate.matches("\\d{2}/\\d{2}")) {
			String[] parts = expirationDate.split("/");
			int month = Integer.parseInt(parts[0]);
			int year = Integer.parseInt(parts[1]);

			int currentYear = 2023;

			return year >= (currentYear % 100) && month >= 1 && month <= 12;
		}

		return false;
	}

	private boolean isValidCvv(String cvv) {

		return cvv != null && cvv.matches("\\d{3}");
	}

}
