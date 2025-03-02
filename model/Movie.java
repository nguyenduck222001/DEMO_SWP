/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Acer Predator
 */
public class Movie {
    private int MovieID;
    private String Title;
    private String Genre;
    private String Summary;
    private int Duration;
    private Date ReleaseDate;
    private String TrailerURL;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private String ImageURL;
    private String Status;

    public Movie() {
    }

    public Movie(int MovieID, String Title, String Genre, String Summary, int Duration, Date ReleaseDate, String TrailerURL, Timestamp CreatedAt, Timestamp UpdatedAt, String ImageURL, String Status) {
        this.MovieID = MovieID;
        this.Title = Title;
        this.Genre = Genre;
        this.Summary = Summary;
        this.Duration = Duration;
        this.ReleaseDate = ReleaseDate;
        this.TrailerURL = TrailerURL;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
        this.ImageURL = ImageURL;
        this.Status = Status;
    }

    

   

    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int MovieID) {
        this.MovieID = MovieID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public String getTrailerURL() {
        return TrailerURL;
    }

    public void setTrailerURL(String TrailerURL) {
        this.TrailerURL = TrailerURL;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = (Timestamp) CreatedAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt) {
        this.UpdatedAt = (Timestamp) UpdatedAt;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Movie{" + "MovieID=" + MovieID + ", Title=" + Title + ", Genre=" + Genre + ", Summary=" + Summary + ", Duration=" + Duration + ", ReleaseDate=" + ReleaseDate + ", TrailerURL=" + TrailerURL + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + ", ImageURL=" + ImageURL + ", Status=" + Status + '}';
    }
    

    
   
    
    
    
}
