package com.cadd.foodplaza.pojo;

public class Order 
{
	private int OrderId;
	private double totalBill;
	private String foodName,OrderDate,custEmailId;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public double gettotalBill() {
		return totalBill;
	}
	public void settotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getcustEmailId() {
		return custEmailId;
	}
	public void setcustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	
	
	
}
