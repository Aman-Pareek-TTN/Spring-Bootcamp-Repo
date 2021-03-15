package com.jpql.component.mapping;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    String plot;
    String street;
    String area;
    String city;
    int pincode;

    public Address(String plot, String street, String area, String city, int pincode) {
        this.plot = plot;
        this.street = street;
        this.area = area;
        this.city = city;
        this.pincode = pincode;
    }

    public Address() {
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
