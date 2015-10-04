package com.frontlinedubai.dao;


import com.frontlinedubai.model.User;

public interface UserDao {

    public void registerUser(User user);

    public void deleteUser(User user);

    public void updateUser(int userId, User user);

    public User getUserByUserName(String userName);
}
