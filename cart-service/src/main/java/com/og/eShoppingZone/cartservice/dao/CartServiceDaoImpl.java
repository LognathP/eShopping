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

import com.og.eShoppingZone.cartservice.constant.QueryConstants;
import com.og.eShoppingZone.cartservice.entity.Cart;
import com.og.eShoppingZone.cartservice.entity.Item;
import com.og.eShoppingZone.cartservice.logger.CommonLogger;


@Component
public class CartServiceDaoImpl implements CartServiceDao {

	@Autowired
	CommonLogger logger;
	
	@Autowired
	JdbcTemplate jdbcTemp;
		
	@Override
	public Cart addCart(Cart cart) {
		PreparedStatement preStmt = null;
		Connection connection = null;
		ResultSet res = null;
		int id = 0;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.INSERT_CART,new String[] {"id"});
			preStmt.setDouble(1, cart.getTotalPrice());
			int rs = preStmt.executeUpdate();
			if(rs > 0)
			{
				res = preStmt.getGeneratedKeys();
				if(res.next())
				{
					id = res.getInt(1);
				}
			}
			for (Item item : cart.getItem()) {
				item.setCart_id(id);
				addItem(item);
			}
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE addCart " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				res.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB addCart " + e.getMessage());
			}

		}
		return cart;
	}
	
	public void addItem(Item item) {
		PreparedStatement preStmt = null;
		Connection connection = null;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.INSERT_ITEM);
			preStmt.setString(1, item.getProductName());
			preStmt.setDouble(2, item.getPrice());
			preStmt.setInt(3, item.getQuantity());
			preStmt.setInt(4, item.getCart_id());
			preStmt.executeUpdate();
			
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE addItem " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB addItem " + e.getMessage());
			}

		}
	}

	@Override
	public List<Cart> getAllcarts() {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		PreparedStatement preStmt1 = null;
		ResultSet res1 = null;
		List<Cart> cartList = new ArrayList<>();
		
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.GET_ALL_CART);
			res = preStmt.executeQuery();
			while(res.next()) {
				Cart cart = new Cart();
				cart.setId(res.getInt(1));
				cart.setTotalPrice(res.getDouble(2));
				preStmt1 = connection.prepareStatement(QueryConstants.GET_ITEM);
				preStmt1.setInt(1, cart.getId());
				res1 = preStmt1.executeQuery();
				List<Item> itemList = new ArrayList<>();
				while(res1.next())
				{
					Item item = new Item();
					item.setProductName(res1.getString("product_name"));
					item.setPrice(res1.getDouble("price"));
					item.setQuantity(res1.getInt("quantity"));
					item.setId(res1.getInt("id"));
					item.setCart_id(res1.getInt("cart_id"));
					itemList.add(item);
				}
				preStmt1.close();
				res1.close();
				cart.setItem(itemList);
				cartList.add(cart);
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getAllcarts " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getAllcarts " + e.getMessage());
			}

		}
		return cartList;
	}

	@Override
	public Cart getCartById(int cartId) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		PreparedStatement preStmt1 = null;
		ResultSet res1 = null;
		Cart cart = new Cart();
		List<Item> itemList = new ArrayList<>();
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.GET_CART_BYID);
			preStmt.setInt(1, cartId);
			res = preStmt.executeQuery();
			while(res.next()) {
				cart.setId(res.getInt(1));
				cart.setTotalPrice(res.getDouble(2));
				preStmt1 = connection.prepareStatement(QueryConstants.GET_ITEM);
				preStmt1.setInt(1, cart.getId());
				res1 = preStmt1.executeQuery();
				while(res1.next())
				{
					Item item = new Item();
					item.setProductName(res1.getString("product_name"));
					item.setPrice(res1.getDouble("price"));
					item.setQuantity(res1.getInt("quantity"));
					item.setId(res1.getInt("id"));
					item.setCart_id(res1.getInt("cart_id"));
					itemList.add(item);
				}
				preStmt1.close();
				res1.close();
				cart.setItem(itemList);
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getCartById " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getCartById " + e.getMessage());
			}

		}
		return cart;
	}

	@Override
	public Double getCartTotal(int cartId) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet res = null;
		double total_price = 0;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.GET_CART_BYID);
			preStmt.setInt(1, cartId);
			res = preStmt.executeQuery();
			while(res.next()) {
				total_price = res.getDouble(2);
			
			}

		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE getCartTotal " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preStmt.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB ON getCartTotal " + e.getMessage());
			}

		}
		return total_price;
	}

	@Override
	public Cart updateCart(Cart cart) {
		PreparedStatement preStmt = null;
		PreparedStatement preStmt1 = null;
		Connection connection = null;
		try {
			connection = jdbcTemp.getDataSource().getConnection();
			preStmt = connection.prepareStatement(QueryConstants.UPDATE_CART);
			preStmt.setDouble(1, cart.getTotalPrice());
			preStmt.setInt(2, cart.getId());
			preStmt.executeUpdate();
			for (Item item : cart.getItem()) {
				connection = jdbcTemp.getDataSource().getConnection();
				preStmt1 = connection.prepareStatement(QueryConstants.UPDATE_ITEM);
				preStmt1.setString(1, item.getProductName());
				preStmt1.setDouble(2, item.getPrice());
				preStmt1.setInt(3, item.getQuantity());
				preStmt1.setInt(4, item.getId());
				preStmt1.executeUpdate();
				preStmt1.close();
			}
			
		} catch (Exception e) {
			logger.debug(this.getClass(), "ERROR IN DB WHILE updateCustomerAddress " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(this.getClass(), "ERROR IN DB WHILE CLOSING DB updateCustomerAddress " + e.getMessage());
			}

		}
		return cart;
	}
	
	
	
	
	
		



	

}
