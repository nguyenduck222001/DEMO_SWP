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

    public List<Discount> getDiscountByID(int DiscountID) throws SQLException {
        List<Discount> discounts = new ArrayList<>();
        String sql = "SELECT * FROM Discounts WHERE DiscountID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, DiscountID);
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
}
