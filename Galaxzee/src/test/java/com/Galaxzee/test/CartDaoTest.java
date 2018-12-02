package com.Galaxzee.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Galaxzee.dao.CartDao;
import com.Galaxzee.model.CartItem;

public class CartDaoTest 
{
	private static AnnotationConfigApplicationContext context=null;
	private static CartDao cartDao=null;
	private CartItem ci=null;

	@BeforeClass
	public static void setUpBeforeClass()throws Exception
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.Galaxzee");
		context.refresh();
		cartDao=(CartDao)context.getBean("cartDao");
	}
	
	@Ignore
	@Test
	public void testAddCartItem()
	{
		ci=new CartItem();
		
		ci.setCartId(1000);
		ci.setProductId(2);
		ci.setUserName("Mansi");
		ci.setQuantity(5);
		ci.setSubtotal(890);
		ci.setPaymentStatus("NP");
		ci.setProductName("iphone X");
		ci.setProductPrice(92000);
		System.out.println("Cart details saved");
		assertTrue("Could not save Cart details",cartDao.addCartItem(ci));
	}
	
	@Ignore
	@Test
	public void testUpdateCartItem()
	{
		ci=new CartItem();
		ci.setCartId(1001);
		ci.setProductId(2);
		ci.setUserName("Mansi");
		ci.setQuantity(4);
		ci.setSubtotal(8900);
		ci.setPaymentStatus("NP");
		ci.setProductName("iphone X");
		System.out.println("Cart details saved");
		assertTrue("Could not save Cart details",cartDao.updateCartItem(ci));
	}
	
	@Ignore
	@Test
	public void testDeleteCartItem()
	{
		assertTrue("Could not delete Cart Details",cartDao.deleteCartItem(ci));
	}
	
	@Ignore
	@Test
	public void testGetCartItem()
	{
		CartItem cartItem=cartDao.getCartItem(103);
		
  assertNotNull("Problem in retrieving", cartItem);
  
        System.out.println("----Getting Cart Item-----\n");
		System.out.println(cartItem.getProductName()+"::");
		System.out.println(cartItem.getProductPrice()+"::");
		System.out.println(cartItem.getQuantity()+"::");
		System.out.println(cartItem.getPaymentStatus()+"::");
		System.out.println(cartItem.getSubtotal()+"::");
	}

	@Ignore
	@Test
	public void testListCartItems()
	{
		
		List<CartItem> listCartItems= cartDao.listCartItems("Mansi");
		assertNotNull("Problem in retrieving", listCartItems);
		
		for(CartItem cartItem:listCartItems)
		{
		System.out.println(cartItem.getProductName()+"::");
		System.out.println(cartItem.getProductPrice()+"::");
		System.out.println(cartItem.getQuantity()+"::");
		System.out.println(cartItem.getPaymentStatus()+"::");
		System.out.println(cartItem.getSubtotal()+"::");
		}
	}
}
