package com.cadd.foodplaza.test;
import java.util.ArrayList;
import java.util.Scanner;
import com.cadd.foodplaza.dao.CartDaoImpl;
import com.cadd.foodplaza.dao.CustomerDaoImpl; 
import com.cadd.foodplaza.pojo.Cart;
import com.cadd.foodplaza.pojo.Customer;
public class CartTast 
{
	public static void main (String...args)
	{
		int choice , foodQty,CartId;
		String EmailId;
		String customerEmailId, foodName;
		boolean flag;
		Cart c=new Cart();
		CartDaoImpl cd=new CartDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		
		do
		{
			System.out.println("  Welcome to cadd Foodplaza (cart ) _______\n1.add to cart \n2.delete cart \n3.display cart \n4 Exit");
			System.out.println("enter your choice");
		   choice = sc.nextInt();

		switch(choice)
		 {
		 case 1:
			 System.out.println("*****Enter Below Details to add to cart****");
				System.out.println("Enter Cart Details(customerEmailId,foodName,foodQty)for adding into cart");
				
				customerEmailId =  sc.next();
				foodName = sc.next();
				foodQty = sc.nextInt();
				
				
				c.setCustomerEmailId(customerEmailId);
				c.setFoodName(foodName);
				c.setFoodQty(foodQty);
				
				flag = cd.addtoCart(c);
				
//				if(flag == true)
//				{
//					System.out.println("Cart Added Successfully");
//				}
//				else
//				{
//					System.out.println("Cart Adding Failed");
//				}
				if(flag)
				{
					System.out.println("Cart Added Successfully");
				}
				else
				{
					System.out.println("Cart Adding Failed");
				}
				
			
			 break;
		 case 2:
			 System.out.println("------------------Enter ID to Delete CartId------------------");
				System.out.println("Enter tha CartId");
				CartId = sc.nextInt();
				flag = cd.deleteCart(CartId);
				if(flag==true)
				{
					System.out.println("CARTID DELETE SUCCESSFULLY.....");
				}
				else
				{
					System.out.println("CARTID DELETE faild");
				}
			 
			 break;
		 case 3:
			 System.out.println("Dilails oF Cart");
		     ArrayList<Cart>ac=new ArrayList<Cart>();
		     System.out.println("Enter your EmailId");
		     EmailId = sc.next();
		     
		     ac=(ArrayList<Cart>) cd.showCart(EmailId);
		 
		     for (Cart i:ac)
		     {
		    	 System.out.println("Cart Id:"+i.getCartId());
		    	 System.out.println("Cart EmailId"+i.getCustomerEmailId());
		    	 System.out.println("food Id"+i.getFoodId());
		    	 System.out.println("food Name"+i.getFoodName());
		    	 System.out.println("Qty Name"+i.getFoodQty());
		    	  
	    	 }
			 break;
			 
		 case 4:
			 System.out.println("khatam tata bye ....Ghari jaa...");
			 break;
	    default:
			 System.out.println(" Invalid Choicve please ");
		 }
	     }while(choice<4);
}
}
	
