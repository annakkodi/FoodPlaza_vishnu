package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cadd.foodplaza.pojo.Cart;
import com.cadd.foodplaza.pojo.Order;
import com.cadd.foodplaza.utility.DBUtility;

public class OrderDaoImpl implements OrderDao
{
	Order O=new Order();
	Connection conn;
	String query;
	PreparedStatement ps;
	public boolean placeOrder(String custEmailId) 
	{
		double totalBill = 0;
		String OrderDate = new Date().toString();
		try {
			Connection con = DBUtility.establishConnection();
			String foodNameQuery = "SELECT foodName FROM Cart WHERE custEmailId = ?";
	        // Calculate totalBill
	        String querytotalBill = "SELECT SUM(f.foodPrice * c.foodQty) AS totalBill " +
	                "FROM Food AS f INNER JOIN Cart AS c ON f.foodId = c.foodId " +
	                "WHERE custEmailId = ?";
	        ps = con.prepareStatement(foodNameQuery);
	         ps.setString(1, custEmailId);
	         ResultSet rs = ps.executeQuery();
	         
	         if(rs.next())
	         {
	        	 String foodName = rs.getString(1);
	        
	        try (PreparedStatement pstotalBill = con.prepareStatement(querytotalBill)) {
	            pstotalBill.setString(1, custEmailId);
	            try (ResultSet rstotalBill = pstotalBill.executeQuery()) {
	                if (rstotalBill.next()) {
	                    totalBill = rstotalBill.getDouble("TotalBill");
	                }
	            }
	        }
	        String queryInsertOrder = "INSERT INTO Orders(totalBill, custEmailId, orderDate,foodName) VALUES (?,?, ?, ?)";
	        try (PreparedStatement psInsertOrder = con.prepareStatement(queryInsertOrder)) {
	            psInsertOrder.setDouble(1, totalBill);
	            psInsertOrder.setString(2, custEmailId);
	            psInsertOrder.setString(3, OrderDate);
	            psInsertOrder.setString(4, foodName);
			
	            int row = psInsertOrder.executeUpdate();
	            return row > 0;
	        }
	     catch (SQLException e) {
	        e.printStackTrace(); // Consider logging the exception instead
	    }
	    }
	    return false;
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Order> ShowOrders() 
	{
		query=" select * from Orders";
		ArrayList<Order>aO=new ArrayList<Order>();
		try {
			conn=DBUtility.establishConnection();
			ps= conn.prepareStatement(query);		
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order O=new Order();
				O.setOrderId(rs.getInt(1));
				O.setcustEmailId(rs.getString(2));
				O.setFoodName(rs.getString(3));
				O.setOrderDate(rs.getString(4));
				O.settotalBill(rs.getInt(5));
				aO.add(O);
			}	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return aO;
	}
	
}
