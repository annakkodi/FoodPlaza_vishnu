package com.cadd.foodplaza.test;
import com.cadd.foodplaza.pojo.*;
import com.cadd.foodplaza.dao. FoodDaoImpl;
import java.util.Scanner;
import java.util.ArrayList;

public class FoodTest 
{
	public static void main(String...args)
	{
	int choice,foodId;
	String foodName,foodType,foodCategory;
	double foodPrice;
	
	
	Food f = new Food();
	FoodDaoImpl fd = new  FoodDaoImpl();
	boolean flag;
	Scanner sc = new Scanner(System.in);
	do
	{
		System.out.println("*********WELCOM TO CADD FOODPLAZE*********\n1.add.Food \n2.update Food\n3.delete food\n4.display Food By Id\n5.display All Food\n6.Exit");
		System.out.println("Enter your choice :");
		choice = sc.nextInt();
		switch(choice)
		{
		//System.out.println("____________ENTERR BELOW DETAILS TO ADD FOOD_________________");
		case 1:
			System.out.println("____________ENTERR BELOW DETAILS TO ADD FOOD_________________");
			System.out.println("ENTER FOOD NAME.FOOD type ,food category,food price_________________");
			foodName = sc.next();
			foodType = sc.next();
			foodCategory = sc.next();
			foodPrice = sc.nextDouble();
			
			
			f.setFoodName(foodName);
			f.setFoodType(foodType);
			f.setFoodCategory(foodCategory);
			f.setFoodprice(foodPrice);
			
			 
			flag = fd.addFood(f);
			if(flag == true)
			{
				System.out.println("FOOD add SUCCESSFULLY.....");
			}
			else
			{
				System.out.println("Food add faild");
			}
			break;
		case 2:
			System.out.println("____________ENTERR ID TO  update Food _________________");
			System.out.println("Enter th Food ID");
		     foodId = sc.nextInt();
		    System.out.println("Enter tha Food NAME");
		    foodName = sc.next();
		    System.out.println("Enter tha Food Type");
			foodType=sc.next();
			System.out.println("Enter tha Food Category");
			foodCategory=sc.next();
			System.out.println("Enter tha Food price");
			foodPrice=sc.nextDouble();
			
			f.setFoodId(foodId);
			f.setFoodName(foodName);
			f.setFoodType(foodType);
			f.setFoodCategory(foodCategory);
			f.setFoodprice(foodPrice);
			flag = fd.updateFood(f);
			if(flag == true)
			{
				System.out.println("FOOD Update SUCCESSFULLY.....");
			}
			else
			{
				System.out.println("Food Update faild");
			}
			
			
			break;
		case 3:
			System.out.println("____________ENTERR delete food_________________");
			System.out.println("Enter tha FOODId");
			foodId = sc.nextInt();
			flag = fd.deleteFood(foodId);
			if(flag==true)
			{
				System.out.println("FOOD Delete SUCCESSFULLY.....");
			}
			else
			{
				System.out.println("Food Delete faild");
			}
			
			break;
		case 4:
			System.out.println("____________ENTERR display Food By Id_________________");
			System.out.println("Enter Food Id");
			foodId=sc.nextInt();
			
			f=fd.displayFoodById(foodId);
			System.out.println("******FOOD DETAILS******");
			System.out.println(f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice());

			break;
		case 5:
			System.out.println("____________ENTERR display All Food_________________");
			ArrayList<Food>af=new ArrayList<Food>();
			af=fd.displayAllFood();
			
			for(Food i:af)
			{
				System.out.println("Food Id:"+i.getFoodId());
				System.out.println("Food Name:"+i.getFoodName());
				System.out.println("Food Type:"+i.getFoodType());
				System.out.println("Food Category:"+i.getFoodCategory());
				System.out.println("Food Price:"+i.getFoodPrice());
				System.out.println();
			}

			break;
		default:
			System.out.println("Invalid choice ...please Rnter Correct choice");
			
		}
	}while(choice<6);

}
}
