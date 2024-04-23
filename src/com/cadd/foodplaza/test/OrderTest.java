package com.cadd.foodplaza.test;
import java.util.*;

import com.cadd.foodplaza.pojo.Order;
import com.cadd.foodplaza.dao.OrderDaoImpl;
public class OrderTest 
{
	public static void main(String...args)
	{
		int OrderId,choice;
		double totalBill;
		String Name,Date,EmailId;
		boolean flag;
		Order or= new Order(); 
		OrderDaoImpl od = new OrderDaoImpl();
		Scanner sc = new Scanner(System.in);
	    System.out.println("*********WELCOM TO FOOD Plaze (ORDER MODULE)**********");
	    System.out.println("1.Place Order");
	    System.out.println("2.Show Order :");
	    System.out.println("Enter your choice:");
		choice = sc.nextInt();
		switch(choice)
			{
			case 1:
				System.out.println("********Place Order*********");
				System.out.println("Customer EmailId");
				EmailId = sc.next();
				or.setcustEmailId(EmailId);	
				flag=od.placeOrder(EmailId);
				if(flag == true)
				{
					System.out.println("place order Sccessfull");
				}
				else
				{
					System.out.println("place order failed");
				}
				break;
			case 2:
				System.out.println("**********Show Order****************");
				List<Order>aO = new ArrayList<Order>();
				aO = od.ShowOrders();
			    for(Order i:aO)
			    {
				System.out.println("Order Id"+i.getOrderId());
				System.out.println("Customer EmailId :"+i.getcustEmailId());
				System.out.println("food name :"+i.getFoodName());
				System.out.println("Ordet Date :"+i.getOrderDate());
				System.out.println("Tatal Bill:"+i.gettotalBill());
				}
				break;
				
			 default:
				 System.out.println(" Invalid Choicve please ");
			}
	}
}
