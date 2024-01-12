package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Discount;

public interface DiscountService {
	List<Discount> getAllDiscounts();

	Discount getDiscountById(Long id);

	Discount createDiscount(Discount discount);

	Discount updateDiscount(Long id, Discount updatedDiscount);

	void deleteDiscount(Long id);
}
