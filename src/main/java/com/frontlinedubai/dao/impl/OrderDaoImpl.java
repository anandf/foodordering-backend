package com.frontlinedubai.dao.impl;


import com.frontlinedubai.dao.OrderDao;
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
public class OrderDaoImpl implements OrderDao {

    private NamedParameterJdbcTemplate  template;

    private RowMapper<Order> orderMapper = (rs, rowNum) -> {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setUserId(rs.getInt("userId"));
        order.setCuisineId(rs.getInt("cuisineId"));
        order.setOrderStartDate(rs.getDate("orderStartDate"));
        order.setOrderEndDate(rs.getDate("orderEndDate"));
        order.setOrderPlacedDate(rs.getDate("orderPlacedDate"));
        order.setSpecialNotes(rs.getString("specialNotes"));
        return order;
    };

    @Autowired
    public OrderDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addOrder(Order order) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", order.getId());
        params.put("userId", order.getUserId());
        params.put("cuisineId", order.getCuisineId());
        params.put("orderStartDate", order.getOrderStartDate());
        params.put("orderEndDate", order.getOrderEndDate());
        params.put("orderPlacedDate", order.getOrderPlacedDate());
        params.put("specialNotes", order.getSpecialNotes());

        String sql = "INSERT INTO order (id, userId, cuisineId, orderStartDate, orderEndDate, orderPlacedDate, specialNotes) " +
                "values (:id, :userId, :cuisineId, :orderStartDate, :orderEndDate, :orderPlacedDate, :specialNotes)";

        template.update(sql,  params);

    }

    @Override
    public List<Order> getOrdersByUserName(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", userName);

        String sql = "SELECT O.* FROM order O, user U WHERE O.userId=U.id and U.userName=:name";

        List<Order> list = template.query(
                sql,
                params,
                orderMapper);

        return list;
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", orderId);

        String sql = "SELECT * FROM order WHERE order.id=:id";

        List<Order> list = template.query(
                sql,
                params,
                orderMapper);

        if (!list.isEmpty())
            return list.get(0);
        return null;
    }
}
