package com.Galaxzee.dao;

import com.Galaxzee.model.Orders;

public interface OrderDao 
{
	public boolean addOrderDetail(Orders orderDetail);

	public boolean updateOrderDetail(String userName);

	public boolean deleteOrderDetail(Orders orderDetail);
}
