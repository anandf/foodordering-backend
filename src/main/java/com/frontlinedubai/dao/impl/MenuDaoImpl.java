package com.frontlinedubai.dao.impl;


import com.frontlinedubai.dao.MenuDao;
import com.frontlinedubai.dao.OrderDao;
import com.frontlinedubai.model.Menu;
import com.frontlinedubai.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuDaoImpl implements MenuDao {

    private NamedParameterJdbcTemplate  template;

    private RowMapper<Menu> menuMapper = (rs, rowNum) -> {
        Menu menu = new Menu();
        menu.setId(rs.getInt("id"));
        menu.setCuisineId(rs.getInt("cuisineId"));
        menu.setDayOfTheWeek(rs.getString("dayOfTheWeek"));
        menu.setDescription(rs.getString("description"));
        menu.setImage(rs.getString("image"));
        return menu;
    };

    @Autowired
    public MenuDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<Menu> getAllMenus() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM menu";

        List<Menu> list = template.query(
                sql,
                params,
                menuMapper);

        return list;
    }

    @Override
    public List<Menu> getAllMenusByCuisine(String cuisineName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cuisineName", cuisineName);
        String sql = "SELECT M.* FROM menu M, cuisine C WHERE M.cuisineId = C.id AND C.name=:cuisineName";

        List<Menu> list = template.query(
                sql,
                params,
                menuMapper);
        return list;
    }

    @Override
    public List<Menu> getAllMenusByCuisineAndCategory(String cuisineName, String category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cuisineName", cuisineName);
        params.put("category", category);
        String sql = "SELECT M.* FROM menu M, cuisine C, category K WHERE M.cuisineId = C.id AND C.name =:cuisineName" +
                "AND M.categoryId=K.id AND K.name=:category";

        List<Menu> list = template.query(
                sql,
                params,
                menuMapper);
        return list;
    }
}
