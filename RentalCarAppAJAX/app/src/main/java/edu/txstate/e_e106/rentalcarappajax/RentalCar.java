package edu.txstate.e_e106.rentalcarappajax;

import org.json.JSONObject;

public class RentalCar {

    private int id;
    private String name;
    private String brand;
    private String color;
    private double rentCost;

    public RentalCar(JSONObject carObject){

        try{
            this.id = carObject.getInt("car_id");
            this.name = carObject.getString("car_name");
            this.brand = carObject.getString("car_brand");
            this.color = carObject.getString("car_color");
            this.rentCost = carObject.getDouble("car_rent");
        }
        catch(Exception ex){ex.printStackTrace();}

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }
}