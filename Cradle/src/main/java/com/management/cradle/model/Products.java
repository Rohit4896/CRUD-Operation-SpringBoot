package com.management.cradle.model;

import jakarta.persistence.*;


@Entity
@Table(name="Products")
@SecondaryTable(name = "productDetails", pkJoinColumns = @PrimaryKeyJoinColumn(name = "productId"))
public class Products {

	@Id 
	@Column(name="productId")
	private String id;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="imagePath")
	private String imagePath;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productDetailsId", table = "productDetails")
	private String productDetailsId;
	
	@Column(name = "totalStock", table = "productDetails")
	private Integer totalStock;
	
	@Column(name = "unitPrice", table = "productDetails")
	private Integer price;
	
	@Column(name = "totalPrice", table = "productDetails")
	private Integer totalPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(String productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	public Integer getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Integer totalStock) {
		this.totalStock = totalStock;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", imagePath=" + imagePath
				+ ", productDetailsId=" + productDetailsId + ", totalStock=" + totalStock + ", price=" + price
				+ ", totalPrice=" + totalPrice + "]";
	}
	
}
