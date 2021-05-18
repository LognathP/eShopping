package com.og.eShoppingZone.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.cartservice.dao.CartServiceDao;
import com.og.eShoppingZone.cartservice.dao.OrderServiceDao;
import com.og.eShoppingZone.cartservice.entity.Address;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.entity.Order;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;


@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	OrderServiceDao orderDao;

		
	@Override
	public List<Order> getAllOrders() {
		try {
			return orderDao.getAllOrders();
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllOrders "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		try {
			return orderDao.getAllAddress();
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAllAddress "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<Order> getOrderbyCustomerId(int customerId) {
		try {
			return orderDao.getOrderbyCustomerId(customerId);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getOrderbyCustomerId "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<Address> getAddressbyCustomerId(int customerId) {
		try {
			return orderDao.getAddressbyCustomerId(customerId);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON getAddressbyCustomerId "+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean placeOrder(Order order) {
		try {
			return orderDao.placeOrder(order);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON placeOrder "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean storeAddress(Address address) {
		try {
			return orderDao.storeAddress(address);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON storeAddress "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean changeOrderStatus(int orderId,int orderStatus) {
		try {
			return orderDao.changeOrderStatus(orderId,orderStatus);
					
		} catch (Exception e) {
			logger.error(this.getClass(),"ERROR OCCURED ON changeOrderStatus "+e.getMessage());
		}
		return false;
	}


	
		



	

}
