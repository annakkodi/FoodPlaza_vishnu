package com.cadd.foodplaza.dao;
import java.util.List;

import com.cadd.foodplaza.pojo.Cart;
public interface CartDao 
{
	boolean addtoCart(Cart ct);
	boolean deleteCart(int cartId);
	List<Cart>showCart(String emailId);
}





