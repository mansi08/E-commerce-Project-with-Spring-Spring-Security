package com.GalaxzeeFront.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Galaxzee.dao.CartDao;
import com.Galaxzee.dao.ProductDao;
import com.Galaxzee.dao.UserDao;
import com.Galaxzee.model.CartItem;
import com.Galaxzee.model.User;

@Controller
public class HomeController 
{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value= {"/","Home","index"})
	public String home()
	{
		
		return "index";
	}

	@RequestMapping(value= "/AboutUs")
	public String aboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping(value= "/ContactUs")
	public String contactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping(value= "/login")
	public String Login(@RequestParam(name="error",required=false)String error,Model model)
	{

		if(error!=null) 
		{
			model.addAttribute("Message", "username or password is invalid");
			System.out.println("Something is wrong");
		}
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("role", auth.getAuthorities().toString());
System.out.println(auth.getAuthorities().toString());
		return "Login";
	}
	
	 @RequestMapping(value="/Register")
     public String RegisterPage(Model model)
     {
		 model.addAttribute("user",new User());
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
			model.addAttribute("role", auth.getAuthorities().toString());
	
    	 return "Register";
}
	 
	 @RequestMapping(value="/Cart")
     public String CartPage(Model model,HttpSession session)
     {
				String username=(String)session.getAttribute("username");
				
				List<CartItem> cartItemList=cartDao.listCartItems(username);
				model.addAttribute("cartItems", cartItemList);
				model.addAttribute("grandTotal",this.grandTotal(cartItemList));
				model.addAttribute("cartList",cartDao.listCartItems(username));
				return "Cart";
	}
			
	 public double grandTotal(List<CartItem> listCartItems)
			{
				double grandTotal=0.0;
				for(CartItem cartItem:listCartItems)
				{
					grandTotal=grandTotal+cartItem.getQuantity()*(productDao.getProduct(cartItem.getProductId()).getProductPrice());
				}
				System.out.println(grandTotal);
				return grandTotal;
				
		}
    	

}	 
	

