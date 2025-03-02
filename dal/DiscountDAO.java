/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import model.Discount;
import dal.DBContext;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Acer Predator
 */
public class DiscountDAO extends DBContext {
    public List<Discount> getAllDiscount() throws SQLException { 
    List<Discount> discounts = new ArrayList<>();
        String sql = "SELECT * FROM Discounts";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set start date as the second parameter

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    Discount discount = new Discount();
                    discount.setDiscountID(rs.getInt("DiscountID"));
                    discount.setDiscountCode(rs.getString("DiscountCode"));
                    discount.setDiscountPercentage(rs.getFloat("DiscountPercentage"));
                    discount.setExpiryDate(rs.getDate("ExpiryDate"));
                    discount.setAdminID(rs.getInt("AdminID"));
                    discount.setDateRelease(rs.getDate("DateRelease"));
                    discount.setImageURL(rs.getString("ImageURL"));
                    discounts.add(discount);
                }
            }

            return discounts;
        }
    }
     public List<Discount> getHomeDiscount() throws SQLException { 
    List<Discount> discounts = new ArrayList<>();
        String sql = "SELECT * FROM Discounts where DiscountID =1 or DiscountID =2";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set start date as the second parameter

            try (ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    Discount discount = new Discount();
                    discount.setDiscountID(rs.getInt("DiscountID"));
                    discount.setDiscountCode(rs.getString("DiscountCode"));
                    discount.setDiscountPercentage(rs.getFloat("DiscountPercentage"));
                    discount.setExpiryDate(rs.getDate("ExpiryDate"));
                    discount.setAdminID(rs.getInt("AdminID"));
                    discount.setDateRelease(rs.getDate("DateRelease"));
                    discount.setImageURL(rs.getString("ImageURL"));
                    discounts.add(discount);
                }
            }

            return discounts;
        }
    }
     public Discount getDiscountByID(int DiscountID) {
        Discount discount = null;

        
            String query = "SELECT * from Discount where DiscountID =? ";
            // Create prepared statement
             try (
        // Create PreparedStatement
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
        statement.setInt(1, DiscountID);

        try (
            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery()
        ) {
            // Check if a matching product is found
            if (resultSet.next()) {
                // Retrieve product details from the result set
                int id = resultSet.getInt("DiscountID");
                String code = resultSet.getString("DiscountCode");
                float percent = resultSet.getFloat("DiscountPercentage");
                Date expiry = resultSet.getDate("DateExpiry");
                int adminID = resultSet.getInt("AdminID");
                Timestamp create = resultSet.getTimestamp("CreateAt");
                Date release = resultSet.getDate("DateRelease");
                String img = resultSet.getString("ImageURL");

                // Create a Product object with the retrieved data
                discount = new Discount(id, code, percent, expiry, adminID, create, release, img);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product details: " + e.getMessage());
        }
    } catch (SQLException e) {
        System.out.println("Error preparing statement: " + e.getMessage());
    }

    return discount;
    }
    
}
