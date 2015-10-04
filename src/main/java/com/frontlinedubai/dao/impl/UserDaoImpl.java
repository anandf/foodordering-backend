package com.frontlinedubai.dao.impl;


import com.frontlinedubai.dao.UserDao;
import com.frontlinedubai.model.Order;
import com.frontlinedubai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate template;

    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setPhonenumber(rs.getString("phonenumber"));
        return user;
    };

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void registerUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", user.getId());
        params.put("userName", user.getUserName());
        params.put("password", user.getPassword());
        params.put("email", user.getEmail());
        params.put("phonenumber", user.getPhonenumber());

        String sql = "INSERT INTO user (id, userName, password, email, phonenumber) " +
                "values (:id, :userName, :password, :email, :phonenumber)";

        int update = template.update(sql, params);
    }

    @Override
    public void deleteUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", user.getId());

        String sql = "DELETE FROM user WHERE id=:id";

        template.update(sql, params);
    }

    @Override
    public void updateUser(int userId, User user) {

    }

    @Override
    public User getUserByUserName(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName.trim());

        System.out.println("Getting user with userName: " + userName.trim());
        String sql = "SELECT * FROM user WHERE userName=:userName";

        List<User> usersList = template.query(sql, params, userMapper);
        if (!usersList.isEmpty())
            return usersList.get(0);
        return null;
    }
}
