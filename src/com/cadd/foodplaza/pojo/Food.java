package com.cadd.foodplaza.pojo;
public class Food 
{
//	public Food(int foodid, String foodName, String foodType, String foodCategory, double foodprice) {
//		super();
//		this.foodid = foodid;
//		FoodName = foodName;
//		this.foodType = foodType;
//		this.foodCategory = foodCategory;
//		this.foodprice = foodprice;
//	}
	private int foodId;
	private String FoodName,foodType,foodCategory;
	private double foodPrice;
	public int getFoodId()
	{ 
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public double getFoodPrice() {
		return foodPrice;
		
	}
	public void setFoodprice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	

}