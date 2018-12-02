package com.GalaxzeeFront.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Galaxzee.dao.CartDao;
import com.Galaxzee.dao.CategoryDao;
import com.Galaxzee.dao.OrderDao;
import com.Galaxzee.dao.ProductDao;
import com.Galaxzee.dao.UserDao;
import com.Galaxzee.model.CartItem;
import com.Galaxzee.model.Orders;

@Controller
public class OrderController 
{
	@Autowired
	HttpSession httpsession;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CartDao cartDao;
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	OrderDao orderDao;

	@RequestMapping("/ConfirmOrder")
	public String confirmOrder(HttpSession session, Model model) 
	{
		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDao.listCartItems(username);
		model.addAttribute("cartItems", cartItemList);
		model.addAttribute("grandTotal",this.grandTotal(cartItemList));
		
		return "OrderConfirm";
	}

	@RequestMapping("/PaymentConfirm")
	public String paymentConfirm(@RequestParam("pmode") String pmode, @RequestParam("shippAddr") String shipAddr,HttpSession session,Model model) 
	{

		Orders order=new Orders();
		order.setOrderDate(new Date());
		order.setShippingAddress(shipAddr);
		order.setPaymentMode(pmode);
		order.setTotalPurchaseAmount(this.grandTotal(cartDao.listCartItems(session.getAttribute("username").toString())));
		order.setUserName(session.getAttribute("username").toString());
		
		int cartid = 0;
	    int cartItemId = 0;
	    
	    for (CartItem cart : cartDao.listCartItems(session.getAttribute("username").toString()))
	    {
	    	cartid = cart.getCartId();
	    	cartItemId = cart.getCartItemId();
	    }
	    
		order.setCartId(cartid);
		orderDao.addOrderDetail(order);
		cartDao.deleteCartItem(cartDao.getCartItem(cartItemId));
		
		System.out.println(session.getAttribute("username").toString());
		
	return "ThankYou";	
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