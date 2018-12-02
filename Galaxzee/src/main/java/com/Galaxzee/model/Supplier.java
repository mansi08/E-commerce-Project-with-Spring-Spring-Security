package com.Galaxzee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
	@Id
	@GeneratedValue
	int supplier_Id;

	String supplier_Name;
	String supplier_Address;
	String supplier_Desc;
	String pan_No;
	String aadhar_No;
	String email;
	String mobile;
	String gstin_No;
	String supplier_Company_Name;
	int quantity;
	
	
	public int getSupplier_Id() 
	{
		return supplier_Id;
	}
	
	public void setSupplier_Id(int supplier_Id) 
	{
		this.supplier_Id = supplier_Id;
	}
	
	public String getSupplier_Name() 
	{
		return supplier_Name;
	}
	
	public void setSupplier_Name(String supplier_Name) 
	{
		this.supplier_Name = supplier_Name;
	}
	
	public String getSupplier_Address() 
	{
		return supplier_Address;
	}
	
	public void setSupplier_Address(String supplier_Address) 
	{
		this.supplier_Address = supplier_Address;
	}
	
	public String getSupplier_Desc() 
	{
		return supplier_Desc;
	}
	
	public void setSupplier_Desc(String supplier_Desc)
	{
		this.supplier_Desc = supplier_Desc;
	}
	
	public String getPan_No()
	{
		return pan_No;
	}
	
	public void setPan_No(String pan_No)
	{
		this.pan_No = pan_No;
	}
	
	public String getAadhar_No()
	{
		return aadhar_No;
	}
	
	public void setAadhar_No(String aadhar_No)
	{
		this.aadhar_No = aadhar_No;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getMobile()
	{
		return mobile;
	}
	
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	public String getGstin_No()
	{
		return gstin_No;
	}
	
	public void setGstin_No(String gstin_No)
	{
		this.gstin_No = gstin_No;
	}
	
	public String getSupplier_Company_Name()
	{
		return supplier_Company_Name;
	}
	
	public void setSupplier_Company_Name(String supplier_Company_Name)
	{
		this.supplier_Company_Name = supplier_Company_Name;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
}
