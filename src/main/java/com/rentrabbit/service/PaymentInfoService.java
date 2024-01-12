package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.PaymentInfo;

public interface PaymentInfoService {
	List<PaymentInfo> getAllPaymentInfo();

	PaymentInfo getPaymentInfoById(Long id);

	PaymentInfo createPaymentInfo(PaymentInfo PaymentInfoInfo);

	PaymentInfo updatePaymentInfo(Long id, PaymentInfo updatedPaymentInfoInfo);

	void deletePaymentInfo(Long id);
}
