package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.form.ProductOrderForm;
import br.com.projeto.model.ProductOrder;
import br.com.projeto.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderRepository _prdRepository;
	
	public ProductOrder addProductOrder(ProductOrderForm poForm) {
		
		ProductOrder prd = new ProductOrder.ProductOrderBuilder()
			.description(poForm.getDescription())
			.price(poForm.getPrice())
			.quantity(poForm.getQuantity())
			.shippingCost(poForm.getShippingCost())
			.shippingType(poForm.getShippingType())
			.dollarPrice(poForm.getDollarPrice())
			.status(poForm.getStatus()).build();
		
		return _prdRepository.save(prd);
		
	}

}
