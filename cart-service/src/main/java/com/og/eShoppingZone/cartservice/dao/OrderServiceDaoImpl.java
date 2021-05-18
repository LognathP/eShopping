package com.og.eShoppingZone.cartservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.og.eShoppingZone.cartservice.constant.CartServiceQueryConstants;
import com.og.eShoppingZone.cartservice.constant.OrderServiceQueryConstants;
import com.og.eShoppingZone.cartservice.entity.Address;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.entity.Item;
import com.og.eShoppingZone.cartservice.entity.Order;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;


@Component
public class OrderServiceDaoImpl implements OrderServiceDao {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	JdbcTemplate jdbcTemp;
		
	@Override
	public List<Order> getAllOrders() {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		List<Order> orderList = new ArrayList<>();
		
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.GET_ALL_ORDERS);
			res = preStmt.executeQuery();
			while(res.next()) {
				Order order = new Order();
				order.setOrderId(res.getInt(1));
				order.setOrderDate(res.getDate(2));
				order.setCustomerId(res.getInt(3));
				order.setAmountPaid(res.getDouble(4));
				order.setModeOfPayment(res.getString(5));
				order.setOrderStatus(res.getInt(6));
				order.setCartId(res.getInt(7));
				orderList.add(order);
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getAllOrders " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getAllOrders " + e.getMessage());
			}

		}
		return orderList;
	}

	@Override
	public List<Address> getAllAddress() {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		List<Address> addressList = new ArrayList<>();
		
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.GET_ALL_ADDRESS);
			res = preStmt.executeQuery();
			while(res.next()) {
				Address address = new Address();
				address.setId(res.getInt(1));
				address.setCustomerId(res.getInt(2));
				address.setFullName(res.getString(3));
				address.setMobileNumber(res.getString(4));
				address.setFlatNumber(res.getInt(5));
				address.setCity(res.getString(6));
				address.setPinCode(res.getInt(7));
				address.setState(res.getString(8));
				addressList.add(address);;
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getAllAddress " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getAllAddress " + e.getMessage());
			}

		}
		return addressList;
	}

	@Override
	public List<Order> getOrderbyCustomerId(int customerId) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		List<Order> orderList = new ArrayList<>();
		
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.GET_ORDERS_CUSTOMERID);
			preStmt.setInt(1, customerId);
			res = preStmt.executeQuery();
			while(res.next()) {
				Order order = new Order();
				order.setOrderId(res.getInt(1));
				order.setOrderDate(res.getDate(2));
				order.setCustomerId(res.getInt(3));
				order.setAmountPaid(res.getDouble(4));
				order.setModeOfPayment(res.getString(5));
				order.setOrderStatus(res.getInt(6));
				order.setCartId(res.getInt(7));
				orderList.add(order);
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getOrderbyCustomerId " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getOrderbyCustomerId " + e.getMessage());
			}

		}
		return orderList;
	}

	@Override
	public List<Address> getAddressbyCustomerId(int customerId) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		List<Address> addressList = new ArrayList<>();
		
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.GET_ADDRESS_CUSTOMERID);
			preStmt.setInt(1, customerId);
			res = preStmt.executeQuery();
			while(res.next()) {
				Address address = new Address();
				address.setId(res.getInt(1));
				address.setCustomerId(res.getInt(2));
				address.setFullName(res.getString(3));
				address.setMobileNumber(res.getString(4));
				address.setFlatNumber(res.getInt(5));
				address.setCity(res.getString(6));
				address.setPinCode(res.getInt(7));
				address.setState(res.getString(8));
				addressList.add(address);
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getAddressbyCustomerId " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getAddressbyCustomerId " + e.getMessage());
			}

		}
		return addressList;
	}

	@Override
	public boolean placeOrder(Order order) {
		PreparedStatement preStmt = null;
		Connection connection = null;
		boolean stat = false;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.PLACE_ORDER);
			preStmt.setDate(1, order.getOrderDate());
			preStmt.setInt(2, order.getCustomerId());
			preStmt.setDouble(3, order.getAmountPaid());
			preStmt.setString(4, order.getModeOfPayment());
			preStmt.setInt(5, 1);
			preStmt.setInt(6, order.getCartId());
			int rs = preStmt.executeUpdate();
			if(rs > 0)
			{
				stat = true;
			}
		
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE placeOrder " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB placeOrder " + e.getMessage());
			}

		}
		return stat;
	}

	@Override
	public boolean storeAddress(Address address) {
		PreparedStatement preStmt = null;
		Connection connection = null;
		boolean stat = false;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.ADD_ADDRESS);
			preStmt.setInt(1, address.getCustomerId());
			preStmt.setString(2, address.getFullName());
			preStmt.setString(3, address.getMobileNumber());
			preStmt.setInt(4, address.getFlatNumber());
			preStmt.setString(5, address.getCity());
			preStmt.setInt(6, address.getPinCode());
			preStmt.setString(7, address.getState());
			int rs = preStmt.executeUpdate();
			if(rs > 0)
			{
				stat = true;
			}
		
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE storeAddress " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB storeAddress " + e.getMessage());
			}

		}
		return stat;
	}

	@Override
	public boolean changeOrderStatus(int orderId,int orderStatus) {
		PreparedStatement preStmt = null;
		Connection connection = null;
		boolean stat = false;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(OrderServiceQueryConstants.UPDATE_ORDER);
			preStmt.setInt(1, orderStatus);
			preStmt.setInt(2, orderId);
			int rs = preStmt.executeUpdate();
			if(rs > 0)
			{
				stat = true;
			}
		
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE storeAddress " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB storeAddress " + e.getMessage());
			}

		}
		return stat;
	}
	
	
	
	
	
		



	

}
