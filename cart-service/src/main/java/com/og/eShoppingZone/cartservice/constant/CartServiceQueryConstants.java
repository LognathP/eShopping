package com.og.eShoppingZone.cartservice.constant;

public interface CartServiceQueryConstants {

	public String INSERT_CART = "INSERT INTO cart (total_price) VALUES(?)";
	public String INSERT_ITEM = "INSERT INTO item (product_id, price, quantity, cart_id) VALUES(?, ?, ?, ?)";
	public String GET_ALL_CART = "select id,total_price from cart";
	public String GET_ITEM = "select * from item where cart_id = ?";
	public String GET_CART_BYID = "select id,total_price from cart where id = ?";
	public String UPDATE_CART = "update cart set total_price = ? where id = ?";
	public String UPDATE_ITEM = "update item set product_id = ?,price=?,quantity = ? where id = ?";
	public String DELETE_CART = "delete from cart where id = ?";
	public String DELETE_ITEM = "delete from item where cart_id=?";
			
}
