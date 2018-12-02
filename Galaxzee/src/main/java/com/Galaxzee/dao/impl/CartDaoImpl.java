package com.Galaxzee.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Galaxzee.dao.CartDao;
import com.Galaxzee.model.CartItem;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();		
			return false;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();		
			return false;
		}	
	}

	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();		
			return false;
		}
	}

	public CartItem getCartItem(int cartItemId) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
			return cartItem;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<CartItem> listCartItems(String username) 
	{
		try 
		{
			Session session= sessionFactory.openSession();
			Query query= session.createQuery("from CartItem where userName=:username");
			List<CartItem> listCartItem=query.setParameter("username", username).list();
			session.close();
				return listCartItem;	
		}
		catch(Exception e)	
		{
			e.printStackTrace();
			return null;
		}	
	}

}
