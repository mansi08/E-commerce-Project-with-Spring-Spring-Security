package com.Galaxzee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Orders 
{
	@Id
	@GeneratedValue
	int orderId;
	int productId;
	int cartId;
	String productName;
	String productCode;
    String brand;
	String userName;
	Date orderDate;
	double totalPurchaseAmount;
	String paymentMode;
	String ShippingAddress;
	
	public int getOrderId() 
	{
		return orderId;
	}
	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public Date getOrderDate() 
	{
		return orderDate;
	}
	
	public void setOrderDate(Date oderDate) 
	{
		this.orderDate = oderDate;
	}
	
	public double getTotalPurchaseAmount() 
	{
		return totalPurchaseAmount;
	}
	
	public void setTotalPurchaseAmount(int totalPurchaseAmount) 
	{
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
	public String getPaymentMode() 
	{
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) 
	{
		this.paymentMode = paymentMode;
	}
	
	public int getProductId() 
	{
		return productId;
	}
	
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	
	public String getProductName() 
	{
		return productName;
	}
	
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	
	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setProductCode(String productCode) 
	{
		this.productCode = productCode;
	}
	
	public String getBrand() 
	{
		return brand;
	}
	
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	
	public void setTotalPurchaseAmount(double totalPurchaseAmount) 
	{
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
	public int getCartId() 
	{
		return cartId;
	}
	
	public void setCartId(int cartId) 
	{
		this.cartId = cartId;
	}
	
	public String getShippingAddress() 
	{
		return ShippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress) 
	{
		ShippingAddress = shippingAddress;
	}
	
	



}
