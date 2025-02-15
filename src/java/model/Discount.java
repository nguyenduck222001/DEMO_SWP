/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
/**
 *
 * @author Acer Predator
 */
public class Discount {
    private int DiscountID;
    private String DiscountCode;
    private float DiscountPercentage;
    private Date ExpiryDate;
    private int AdminID;
    private Timestamp CreatedAt;
    private Date DateRelease;
    private String ImageURL;

    public Discount() {
    }

    public Discount(int DiscountID, String DiscountCode, float DiscountPercentage, Date ExpiryDate, int AdminID, Timestamp CreatedAt, Date DateRelease, String ImageURL) {
        this.DiscountID = DiscountID;
        this.DiscountCode = DiscountCode;
        this.DiscountPercentage = DiscountPercentage;
        this.ExpiryDate = ExpiryDate;
        this.AdminID = AdminID;
        this.CreatedAt = CreatedAt;
        this.DateRelease = DateRelease;
        this.ImageURL = ImageURL;
    }

    public int getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(int DiscountID) {
        this.DiscountID = DiscountID;
    }

    public String getDiscountCode() {
        return DiscountCode;
    }

    public void setDiscountCode(String DiscountCode) {
        this.DiscountCode = DiscountCode;
    }

    public float getDiscountPercentage() {
        return DiscountPercentage;
    }

    public void setDiscountPercentage(float DiscountPercentage) {
        this.DiscountPercentage = DiscountPercentage;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Timestamp CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public Date getDateRelease() {
        return DateRelease;
    }

    public void setDateRelease(Date DateRelease) {
        this.DateRelease = DateRelease;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    

    @Override
    public String toString() {
        return "Discount{" + "DiscountID=" + DiscountID + ", DiscountCode=" + DiscountCode + ", DiscountPercentage=" + DiscountPercentage + ", ExpiryDate=" + ExpiryDate + ", AdminID=" + AdminID + ", CreatedAt=" + CreatedAt + ", DateRelease=" + DateRelease + ", ImageURL=" + ImageURL + '}';
    }

    
    
     
    
}
