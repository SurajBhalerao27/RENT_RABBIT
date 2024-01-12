package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.Discount;
import com.rentrabbit.repository.DiscountRepository;
import com.rentrabbit.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	DiscountRepository discountRepository;

	public List<Discount> getAllDiscounts() {
		return discountRepository.findAll();
	}

	public Discount getDiscountById(Long id) {
		Optional<Discount> optionalDiscount = discountRepository.findById(id);
		return optionalDiscount.orElse(null);
	}

	public Discount createDiscount(Discount discount) {
		return discountRepository.save(discount);
	}

	public Discount updateDiscount(Long id, Discount updatedDiscount) {
		Optional<Discount> optionalDiscount = discountRepository.findById(id);
		if (optionalDiscount.isPresent()) {
			Discount existingDiscount = optionalDiscount.get();
			existingDiscount.setCode(updatedDiscount.getCode());
			existingDiscount.setPercentage(updatedDiscount.getPercentage());
			return discountRepository.save(existingDiscount);
		}
		return null;
	}

	public void deleteDiscount(Long id) {
		discountRepository.deleteById(id);
	}
}
