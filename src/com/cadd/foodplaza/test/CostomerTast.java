package com.cadd.foodplaza.test;
//phomyadmin -xamop servar
import java.util.ArrayList;
import java.util.Scanner;
import com.cadd.foodplaza.dao.CustomerDaoImpl;
import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;
public class CostomerTast 
{
	public static void main(String...args)
	{
		int choice,customerId;
		String customerName,customerAddress,customerEmailid,customerPassword;
		Long customerContact;
		
		CustomerDaoImpl cd= new CustomerDaoImpl();
		boolean flag ;
		Customer c =new Customer();
		
		
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("*******WELCOME TO CADD CUSTOMER*******\n1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.Display Customer By ID\n5.Display All Customer\n6.Exit\n Enter your Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("------------------Enter Below Details to add Customer------------------");
				System.out.println("Enter tha Customer Name");
				customerName = sc.next();
				System.out.println("Enter tha Customer Address");
				customerAddress=sc.next();
				System.out.println("Customer Contact Number");
				customerContact=sc.nextLong();
				System.out.println("Customer Email_id");
				customerEmailid=sc.next();
				System.out.println(" Enter tha Customer Password");
				customerPassword=sc.next();	
				
				c.setCustomerName(customerName);
				c.setCustomerAddress(customerAddress);
				c.setCustomerContact(customerContact);
				c.setCustomerEmailid(customerEmailid);
				c.setCustomerPassword(customerPassword);
				
				
				flag = cd.addCustomer(c);
				if(flag==true)
				{
					System.out.println("Customer added successfully...");
				}
				else
				{
					System.out.println("Customer Adding Faild");
				}
				
				break;
			case 2:
				System.out.println("------------------Enter ID to Update Customer of your choice------------------");
			     System.out.println("______Enter th Customer ID");
			     customerId = sc.nextInt();
			    System.out.println("_______Enter tha Custemer NAME");
			    customerName = sc.next();
			    System.out.println("_______Enter tha Custemer Address");
				customerAddress=sc.next();
				System.out.println("_______Enter tha Custemer contact");
				customerContact=sc.nextLong();
				System.out.println("Enter tha Custemer EmailId");
				customerEmailid=sc.next();
				System.out.println("Enter tha Custemer password");
				customerPassword=sc.next();
				
				c.setCustomerId(customerId);
				c.setCustomerName(customerName);
				c.setCustomerAddress(customerAddress);
				c.setCustomerContact(customerContact);
				c.setCustomerEmailid(customerEmailid);
				c.setCustomerPassword(customerPassword);
				flag = cd.updateCustomer(c);
				if(flag==true)
				{
					System.out.println("Customer update successfully...");
				}
				else
				{
					System.out.println("Customer update Faild");
				}
				break;
			case 3:
				System.out.println("------------------Enter ID to Delete Customer------------------");
				System.out.println("Enter tha CustomerId");
				customerId = sc.nextInt();
				flag = cd.deleteCustomer(customerId);
				if(flag==true)
				{
					System.out.println("CUSTOMER DELETE SUCCESSFULLY.....");
				}
				else
				{
					System.out.println("CUSTEMER DELETE faild");
				}
				break;
			case 4:
				System.out.println("*******Enter ID to Display Specific Customer********");
				System.out.println("ENTER YOUR CUSTOMER_ID");
				customerId = sc.nextInt();
				c=cd.displayCustomerById(customerId);
				System.out.println("******CUSTEMEDR DETAILS******");
				System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerAddress()+" "+c.getCustomerContact()+" "+c.getCustomerEmailid()+" "+c.getCustomerPassword());

				
				break;
			case 5:
				System.out.println("------------------Existing Customer Details ------------------");
				
				ArrayList<Customer>ac=new ArrayList<Customer>();
				ac=cd.displayAllCustomer();
				for(Customer i:ac)
				{
					System.out.println("Customer Id:"+i.getCustomerId());
					System.out.println("Customer Name:"+i.getCustomerName());
					System.out.println("Customer Address:"+i.getCustomerAddress());
					System.out.println("Customer Contact:"+i.getCustomerContact());
					System.out.println("Customer Emailid:"+i.getCustomerEmailid());
					System.out.println("Customer Password:"+i.getCustomerPassword()); 
					System.out.println();
				}
				break;
			case 6:
				System.out.println("pot bharl aasel tar nigha aata");
				break;
			default:
				System.out.println("Invalid Choice...Please Enter current choice...");
			}
		}while(choice<6);
		}
	}