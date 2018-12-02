package com.Galaxzee.dao;

import java.util.List;

import com.Galaxzee.model.CartItem;

public interface CartDao 
{
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	
	public CartItem getCartItem(int cartItemId);
    public List<CartItem> listCartItems(String username);
}
