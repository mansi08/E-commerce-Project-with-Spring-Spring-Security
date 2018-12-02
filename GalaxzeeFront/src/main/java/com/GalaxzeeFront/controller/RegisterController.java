package com.GalaxzeeFront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Galaxzee.dao.UserDao;
import com.Galaxzee.model.User;


@Controller
public class RegisterController 

{
	@Autowired
	UserDao userDao;
	
	
	
@RequestMapping(value ="/Register", method = RequestMethod.POST)
public String insertUsers(@ModelAttribute("user") User user,Model model)
		
{
		
	List<User> userList=userDao.listUsers();
	
	for(User user1:userList) {
		if(user1.getUserEmail().equals(user.getUserEmail())) 
{
			model.addAttribute("emailMsg", "*Email already Exists");
			
			return "Register";
		}
		if((user1.getUserName().equals(user.getUserName()))) 
		{
			model.addAttribute("userNameMsg", "*Username already Exists");
			
			return "Register";
		}
	}
	
	
	userDao.addUser(user);
	return "Login";
}

}
