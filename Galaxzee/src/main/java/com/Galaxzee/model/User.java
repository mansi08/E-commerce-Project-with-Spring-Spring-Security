package com.Galaxzee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User 
{
	@Id
	String userName;
	String userEmail;
	String userPhoneNumber;
	String userPassword;
	String role;// role _user, role_admin
	String enabled; // true|false
	String coustomername;
	String address;
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getUserEmail() 
	{
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}
	
	public String getUserPhoneNumber() 
	{
		return userPhoneNumber;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.userPhoneNumber = userPhoneNumber;
	}
	
	public String getUserPassword() 
	{
		return userPassword;
	}
	
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getEnabled()
	{
		return enabled;
	}
	
	public void setEnabled(String enabled)
	{
		this.enabled = enabled;
	}
	
	public String getCoustomername()
	{
		return coustomername;
	}
	
	public void setCoustomername(String coustomername)
	{
		this.coustomername = coustomername;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	

}
