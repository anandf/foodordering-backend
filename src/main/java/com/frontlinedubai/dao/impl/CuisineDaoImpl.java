package com.frontlinedubai.dao.impl;

import com.frontlinedubai.dao.CuisineDao;
import com.frontlinedubai.model.Category;
import com.frontlinedubai.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CuisineDaoImpl implements CuisineDao{

    private NamedParameterJdbcTemplate template;

    private RowMapper<Cuisine> cuisineRowMapper = (rs, rowNum) -> {
        Cuisine cuisine = new Cuisine();
        cuisine.setId(rs.getInt("id"));
        cuisine.setName(rs.getString("name"));
        cuisine.setDescription(rs.getString("description"));
        cuisine.setImage(rs.getString("image"));
        return cuisine;
    };

    @Autowired
    public CuisineDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Cuisine> getAllCuisines() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM cuisine";

        List<Cuisine> list = template.query(
                sql,
                params,
                cuisineRowMapper);

        return list;
    }
}
