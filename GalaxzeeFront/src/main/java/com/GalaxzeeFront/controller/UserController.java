package com.GalaxzeeFront.controller;



import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Galaxzee.dao.ProductDao;


@Controller
public class UserController 
{
	@Autowired
	ProductDao productDao;
	
@RequestMapping("/login_success")
public String showHomePage(Model model,HttpSession session)
{
	String page="";
	boolean loggedIn=false;
	
	SecurityContext securityContext=SecurityContextHolder.getContext();
	Authentication authentication=securityContext.getAuthentication();
	
	String UserName=authentication.getName();
	Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
	
	for(GrantedAuthority role:roles)
	{
		session.setAttribute("role", role.getAuthority());
		
		if(role.getAuthority().equals("ROLE_ADMIN"))
		{
		loggedIn=true;
		page="AdminHome";
		session.setAttribute("loggedIn", loggedIn);
		session.setAttribute("username", UserName);
		}
		
		else
		{
			loggedIn=true;
			page="ProductDisplay";
			model.addAttribute("productList", productDao.listProducts());
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username", UserName);	
		}
	}
	 return page;
}
}
