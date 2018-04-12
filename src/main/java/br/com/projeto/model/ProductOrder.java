package br.com.projeto.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

//@Entity
//@EntityListeners(AuditingEntityListener.class)
public class ProductOrder {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@NotBlank
	private final String description;

//	@Column(nullable = false)
	private final Integer quantity;

//	@Column(precision = 10, scale = 2)
	private final Double shippingCost;

//	@Column(precision = 10, scale = 2)
	private final Double dollarPrice;

//	@Column(precision = 10, scale = 2)
	private final Double price;

//	@Column(nullable = false)
	private boolean avaible;

//	@Column(updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date();

//	@Column(nullable = false, updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
	private Date createdAt;

//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
	private Date updatedAt;

	private String shippingType;

	private List<Blob> pictures = new ArrayList<Blob>();

	private ProductOrder(ProductOrderBuilder builder) {
		this.description = builder.description;
		this.quantity = builder.quantity;
		this.shippingCost = builder.shippingCost;
		this.dollarPrice = builder.dollarPrice;
		this.price = builder.price;
		this.avaible = builder.avaible;
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

	public boolean isAvaible() {
		return avaible;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public List<Blob> getPictures() {
		return pictures;
	}

	public void setPictures(List<Blob> pictures) {
		this.pictures = pictures;
	}

	public static class ProductOrderBuilder {
		private String description;
		private Integer quantity;
		private Double shippingCost;
		private Double dollarPrice;
		private Double price;
		private boolean avaible;

		public ProductOrderBuilder() {
		}

		public ProductOrderBuilder description(String description) {
			this.description = description;
			return this;
		}

		public ProductOrderBuilder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public ProductOrderBuilder shippingCost(Double shippingCost) {
			this.shippingCost = shippingCost;
			return this;
		}

		public ProductOrderBuilder dollarPrice(Double dollarPrice) {
			this.dollarPrice = dollarPrice;
			return this;
		}

		public ProductOrderBuilder price(Double price) {
			this.price = price;
			return this;
		}

		public ProductOrderBuilder isAvaible(boolean avaible) {
			this.avaible = avaible;
			return this;
		}

		public ProductOrder build() {
			return new ProductOrder(this);
		}
	}
}
