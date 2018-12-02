package com.Galaxzee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem 
{
	@Id
	@GeneratedValue
	int cartItemId;
	int cartId;
	int productId;
	String productName;
	double productPrice;
	String userName;
	int quantity;
	double subtotal;
String paymentStatus;


public int getCartItemId() 
{
	return cartItemId;
}
public void setCartItemId(int cartItemId) 
{
	this.cartItemId = cartItemId;
}
public int getCartId() 
{
	return cartId;
}
public void setCartId(int cartId) 
{
	this.cartId = cartId;
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
public double getProductPrice() 
{
	return productPrice;
}
public void setProductPrice(double productPrice) 
{
	this.productPrice = productPrice;
}
public String getUserName() 
{
	return userName;
}
public void setUserName(String userName) 
{
	this.userName = userName;
}
public int getQuantity() 
{
	return quantity;
}
public void setQuantity(int quantity) 
{
	this.quantity = quantity;
}
public double getSubtotal() 
{
	return subtotal;
}
public void setSubtotal(double subtotal) 
{
	this.subtotal = subtotal;
}
public String getPaymentStatus() 
{
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) 
{
	this.paymentStatus = paymentStatus;
}


}
