package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "products_info")
@Data
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	@NotBlank(message = "Product name cant be null or blank")
//	@NotNull
//	@NotEmpty//"" not allowed " " allowed
	private String productName;
	@Column(name = "price")
	@Min(value = 100, message = "Product prize should be more than 100Rs")
	@Max(value = 250000, message = "Product prize should be less than 250000Rs")
	private int productPrice;
	@Size(min = 5, max = 12, message = "Category length must be between (5,12)")
	private String productCategory;
	@Column(name = "quantity", length = 8)
	@Positive(message = "Quantity cannot be Zero or -ve")
	private int productQuantity;

	public Product() {

	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
