package com.frontlinedubai.dao.impl;

import com.frontlinedubai.dao.CategoryDao;
import com.frontlinedubai.model.Category;
import com.frontlinedubai.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private NamedParameterJdbcTemplate template;

    private RowMapper<Category> categoryRowMapper = (rs, rowNum) -> {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        category.setDescription(rs.getString("description"));
        return category;
    };

    @Autowired
    public CategoryDaoImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM category";

        List<Category> list = template.query(
                sql,
                params,
                categoryRowMapper);

        return list;
    }
}
