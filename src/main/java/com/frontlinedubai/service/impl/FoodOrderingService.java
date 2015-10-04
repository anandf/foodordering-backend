package com.frontlinedubai.service.impl;


import com.frontlinedubai.dao.*;
import com.frontlinedubai.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodOrderingService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CuisineDao cuisineDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private MenuDao menuDao;


    public void registerUser(User aUser) {
        aUser.setEmail("admin@frontlinedubai.com");
        aUser.setPhonenumber("9999999999");
        aUser.setUserName("admin");
        aUser.setPassword("admin");
        userDao.registerUser(aUser);
    }

    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    public void addOrder(Order order) {
        order.setUserId(userDao.getUserByUserName("admin").getId());
        order.setOrderStartDate(new Date());
        order.setOrderEndDate(new Date());
        order.setSpecialNotes("");
        order.setOrderPlacedDate(new Date());
        orderDao.addOrder(order);
    }

    public LoginResult checkUser(User user) {
        LoginResult result = new LoginResult();
        User userFound = userDao.getUserByUserName(user.getUserName());
        if(userFound == null) {
            result.setError("Invalid username");
        } else if(user.getPassword() != null && !user.getPassword().equals(userFound.getPassword())) {
            result.setError("Invalid password");
        } else {
            result.setUser(userFound);
        }

        return result;
    }

    public List<Order> getAllOrders(String userName) {
        return orderDao.getOrdersByUserName(userName);
    }

    public List<Menu> getMenusForCuisineAndCategory(String cuisineName, String category) {

        return menuDao.getAllMenusByCuisineAndCategory(cuisineName, category);
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public List<Cuisine> getAllCuisines() {
        return cuisineDao.getAllCuisines();
    }

    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }

    public List<Menu> getAllMenusByCuisine(String cuisineName) {
        return menuDao.getAllMenusByCuisine(cuisineName);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
