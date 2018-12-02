package com.Galaxzee.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Galaxzee.dao.OrderDao;
import com.Galaxzee.model.Orders;



public class OrderDaoTest 
{
	private static AnnotationConfigApplicationContext context=null;
	private static OrderDao orderDao=null;
	
	@BeforeClass
	public static void setUpBeforeClass()throws Exception
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.Galaxzee");
		context.refresh();
		orderDao=(OrderDao)context.getBean("orderDao");
	}
	
	@Ignore
	@Test
	public void testAddOrderDetail() {
		Orders od = new Orders();
		od.setShippingAddress("fdgfdjy");
		od.setBrand("Priyagold");
		od.setCartId(1000);
		od.setOrderDate(new java.util.Date());
		od.setPaymentMode("CC");
		od.setProductCode("PRD37DD528C14");
		od.setProductId(21);
		od.setProductName("Priyagold biskits");
		od.setTotalPurchaseAmount(15.0);
		od.setUserName("Mansi");
		od.setOrderId(1);
		System.out.println("Order Details Saved");
		assertTrue("Problem in inserting Order", orderDao.addOrderDetail(od));
	}

	@Ignore
	@Test
	public void testUpdateOrderDetail() {
		assertTrue("Problem in updateing Orderdetail", orderDao.updateOrderDetail("Mansi"));
	}

	@Ignore
	@Test
	public void testDeleteOrderDetail() {
		fail("Not yet implemented");
}
}
