package com.Galaxzee.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Galaxzee.dao.SupplierDao;
import com.Galaxzee.model.Supplier;

public class SupplierDaoTest 
{
	private static AnnotationConfigApplicationContext context=null;
	private static SupplierDao supplierDao=null;
	private Supplier s=null;

	@BeforeClass
	public static void setUpBeforeClass()throws Exception
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.Galaxzee");
		context.refresh();
		supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	@Ignore
	@Test
	public void testAddSupplier()
	{
		s=new Supplier();
		s.setSupplier_Id(1);
		s.setSupplier_Name("Ramson");
		s.setAadhar_No("1234567891011");
		s.setEmail("r@gmail.com");
		s.setGstin_No("123456AAA129875");
		s.setMobile("9865478632");
		s.setPan_No("CAZP9041P");
		s.setQuantity(56);
		s.setSupplier_Company_Name("Ranson and company");
		System.out.println("Supplier details saved");
		assertTrue("Could not save Category details",supplierDao.addSupplier(s));
	}

	@Ignore
	@Test
	public void testUpdateSupplier()
	{
		s=new Supplier();
		s.setSupplier_Id(1);
		s.setSupplier_Name("Raju");
		s.setAadhar_No("1234567891012");
		s.setEmail("raju@gmail.com");
		s.setGstin_No("123456AAA129875");
		s.setMobile("9865478632");
		s.setPan_No("CAZP9041P");
		s.setQuantity(56);
		s.setSupplier_Company_Name("Ranson and company");
		System.out.println("Supplier details saved");
		assertTrue("Could not save Category details",supplierDao.updateSupplier(s));
		
	}

	@Ignore
	@Test
	public void testDeleteSupplier()
	{
		assertTrue("Could not delete Category Details",supplierDao.deleteSupplier(1));
	}

	@Ignore
	@Test
	public void testGetSupplierById()
	{
		fail("yet not implemented");
	}

	@Ignore
	@Test
	public void testListSupplier()
	{
		List<Supplier> listSupplier= supplierDao.listSupplier();
		assertNotNull("Problem in retrieving", listSupplier);
	}
}
