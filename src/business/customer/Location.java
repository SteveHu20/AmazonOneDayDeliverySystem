/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

/**
 *
 * @author baochenhu
 */
public class Location {
    private String country;
    private String state;
    private String city;
    private String street;
    private double longtitude;
    private double latitude;

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return  street+" "+city+" "+state+" "+country; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
