package com.Galaxzee.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Galaxzee.dao.OrderDao;
import com.Galaxzee.model.Orders;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addOrderDetail(Orders orderDetail) 
	{
		try 
		{
		sessionFactory.getCurrentSession().save(orderDetail);
		return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateOrderDetail(String userName) 
	{
		 try
	        {
	        	Session session=sessionFactory.openSession();
	        	session.beginTransaction(); 
	        	Query query=session.createQuery("update CartItem set status='P' where userName=:myusername and status='NA'");
	             query.setParameter("myusername", userName);
	             int row_eff=query.executeUpdate();
	             
	             if(row_eff>0)
	             {
	            	 session.getTransaction().commit();
	            session.close();
	            }
	             
	             return true;
	        }
	                 
		 catch(Exception e)
	      {
			 e.printStackTrace();
	         return false;
}
	}

	public boolean deleteOrderDetail(Orders orderDetail) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(orderDetail);
			return true;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			return false;
}
	}

}
