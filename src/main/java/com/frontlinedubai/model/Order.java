package com.frontlinedubai.model;


import java.util.Date;
import java.util.List;

public class Order {

    private int id;

    private int userId;

    private int cuisineId;

    private Date orderPlacedDate;

    private Date orderStartDate;

    private Date orderEndDate;

    private String specialNotes;

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int categoryid) {
        this.cuisineId = categoryid;
    }

    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(Date orderPlaced) {
        this.orderPlacedDate = orderPlaced;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userid) {
        this.userId = userid;
    }
}
