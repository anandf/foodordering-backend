package com.frontlinedubai.dao;

import com.frontlinedubai.model.Order;
import com.frontlinedubai.model.User;

import java.util.List;

public interface OrderDao {
    public void addOrder(Order order);

    public List<Order> getOrdersByUserName(String userName);

    public Order getOrderByOrderId(int orderId);


}
