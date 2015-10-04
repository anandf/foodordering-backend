package com.frontlinedubai.dao;


import com.frontlinedubai.model.Menu;

import java.util.List;

public interface MenuDao {

    public List<Menu> getAllMenus();

    public List<Menu> getAllMenusByCuisine(String cuisineName);

    public List<Menu> getAllMenusByCuisineAndCategory(String cuisineName, String category);

}
