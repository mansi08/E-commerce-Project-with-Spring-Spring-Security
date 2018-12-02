package com.GalaxzeeFront.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Galaxzee.dao.CartDao;
import com.Galaxzee.dao.ProductDao;
import com.Galaxzee.model.CartItem;
import com.Galaxzee.model.Product;

@Controller
public class CartController 
{
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;
	
	@RequestMapping(value="/AddToCart/{productId}")
public String addCartItem(@RequestParam("quantity") int quantity,@PathVariable("productId") int productId,Model model,HttpSession session)
{

		Product product=productDao.getProduct(productId);
	
		String username=(String)session.getAttribute("username");
		
		CartItem cartItem=new CartItem();
		
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setProductPrice(product.getProductPrice());
		cartItem.setUserName(username);
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(quantity*product.getProductPrice());
		
		cartDao.addCartItem(cartItem);
		
		List<CartItem> cartItemList=cartDao.listCartItems(username);
		model.addAttribute("cartItems", cartItemList);
		model.addAttribute("grandTotal",this.grandTotal(cartItemList));
		
        return "Cart";	//jsp page returned
}
	
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId,Model model,HttpSession session)
	{
		
		CartItem cartItem=cartDao.getCartItem(cartItemId);
		
		cartDao.deleteCartItem(cartItem);
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> cartItemList=cartDao.listCartItems(username);
		model.addAttribute("cartItems", cartItemList);
		model.addAttribute("grandTotal",this.grandTotal(cartItemList));
		
		return "Cart";	//jsp page returned
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity") int quantity,@PathVariable("cartItemId") int cartItemId,Model model,HttpSession session)
{
		
		CartItem cartItem=cartDao.getCartItem(cartItemId);
		
		int p=cartItem.getProductId();
		
		Product product=productDao.getProduct(p);
		System.out.println(p);
		
		cartItem.setQuantity(quantity);
		cartItem.setSubtotal(quantity*product.getProductPrice());
		
		cartDao.updateCartItem(cartItem);
		
        String username=(String)session.getAttribute("username");
		
		List<CartItem> cartItemList=cartDao.listCartItems(username);
		model.addAttribute("cartItems", cartItemList);
		model.addAttribute("grandTotal",this.grandTotal(cartItemList));
		
		System.out.println(cartItem.getProductId());
		
		return "Cart";	//jsp page returned
}
	
	public double grandTotal(List<CartItem> cartItemList)
	{
		double grandTotal=0.0;
		for(CartItem cartItem:cartItemList)
		{
			grandTotal=grandTotal+cartItem.getQuantity()*(productDao.getProduct(cartItem.getProductId()).getProductPrice());
		}
		System.out.println(grandTotal);
		return grandTotal;
		
}
}
