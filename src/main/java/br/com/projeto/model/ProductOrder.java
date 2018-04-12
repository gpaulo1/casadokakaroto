package br.com.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private final String description;

	@Column(nullable = false)
	private final Integer quantity;

	@Column(precision = 10, scale = 2)
	private final Double shippingCost;

	@Column(precision = 10, scale = 2)
	private final Double dollarPrice;

	@Column(precision = 10, scale = 2)
	private final Double price;

	@Column(nullable = false)
	private final String status;

	private final String shippingType;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date();

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	private ProductOrder(ProductOrderBuilder builder) {
		this.description = builder.description;
		this.quantity = builder.quantity;
		this.shippingCost = builder.shippingCost;
		this.dollarPrice = builder.dollarPrice;
		this.price = builder.price;
		this.status = builder.status;
		this.shippingType = builder.shippingType;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public Double getDollarPrice() {
		return dollarPrice;
	}

	public Double getPrice() {
		return price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date OrderDate) {
		this.orderDate = OrderDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getShippingType() {
		return shippingType;
	}

	public static class ProductOrderBuilder {
		private String description;
		private Integer quantity;
		private Double shippingCost;
		private String shippingType;
		private Double dollarPrice;
		private Double price;
		private String status;

		public ProductOrderBuilder() {
		}

		public ProductOrderBuilder description(String description) {

			if (description == null) {
				throw new NullPointerException("Attribute 'Descrição' can't be null");
			}

			this.description = description;
			return this;
		}

		public ProductOrderBuilder quantity(Integer quantity) {

			if (quantity == null) {
				throw new NullPointerException("Attribute 'Quantidade' can't be null");
			}

			this.quantity = quantity;
			return this;
		}

		public ProductOrderBuilder shippingCost(Double shippingCost) {

			if (shippingCost == null) {
				throw new NullPointerException("Attribute 'Valor do Frete' can't be null");
			}

			this.shippingCost = shippingCost;
			return this;
		}
		
		public ProductOrderBuilder shippingType(String shippingType) {

			if (shippingType == null) {
				throw new NullPointerException("Attribute 'Tipo de frete' can't be null");
			}

			this.shippingType = shippingType;
			return this;
		}

		public ProductOrderBuilder dollarPrice(Double dollarPrice) {

			if (dollarPrice == null) {
				throw new NullPointerException("Attribute 'Valor do Dolar' can't be null");
			}

			this.dollarPrice = dollarPrice;
			return this;
		}

		public ProductOrderBuilder price(Double price) {

			if (price == null) {
				throw new NullPointerException("Attribute 'Valor' can't be null");
			}

			this.price = price;
			return this;
		}

		public ProductOrderBuilder status(String status) {
			this.status = status;
			return this;
		}

		public ProductOrder build() {
			return new ProductOrder(this);
		}
	}
}
