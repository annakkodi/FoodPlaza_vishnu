package com.cadd.foodplaza.dao;
import java.util.ArrayList;
import com.cadd.foodplaza.pojo.Customer;
//import com.cadd.foodplaza.pojo.Food;

public interface customerDao 
{

    boolean addCustomer(Customer c);
	
	boolean updateCustomer(Customer c);
	
	boolean deleteCustomer(int Customerid);
	
	Customer displayCustomerById(int customerId);
	
	ArrayList<Customer>displayAllCustomer();
	
}
