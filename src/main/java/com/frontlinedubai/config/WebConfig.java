package com.frontlinedubai.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frontlinedubai.model.*;
import com.frontlinedubai.service.impl.FoodOrderingService;
import org.apache.commons.beanutils.BeanUtils;


import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.staticFileLocation;
import spark.utils.StringUtils;

public class WebConfig {

    private static final String USER_SESSION_ID = "user";
    private static final String SELECTED_CUISINE = "selected.cuisine";
    private FoodOrderingService service;


    public WebConfig(FoodOrderingService service) {
        this.service = service;
        staticFileLocation("/public");
        setupRoutes();
    }

    private void setupRoutes() {
		/*
		 * Shows a users timeline or if no user is logged in,
		 *  it will redirect to the public timeline.
		 *  This timeline shows the user's messages as well
		 *  as all the messages of followed users.
		 */
        get("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "order");
            map.put("user", user);
            List<Order> orders = service.getAllOrders(user.getUserName());
            map.put("messages", orders);
            return new ModelAndView(map, "order.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            if (user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/categories", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Category");
            map.put("user", user);
            List<Category> categories = service.getAllCategories();
            map.put("categories", categories);
            return new ModelAndView(map, "category.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            if (user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/cuisines", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Cuisine");
            map.put("user", user);
            List<Cuisine> cuisines = service.getAllCuisines();
            map.put("cuisines", cuisines);
            List<Category> categories = service.getAllCategories();
            map.put("categories", categories);
            return new ModelAndView(map, "cuisine.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            if (user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/menu/:cuisineName", (req, res) -> {
            User user = getAuthenticatedUser(req);
            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", "Menu");
            map.put("user", user);
            String cuisineName = new String(req.params(":cuisineName"));
            System.out.println("Cusine for menu:" + cuisineName);
            List<Menu> menus = service.getAllMenusByCuisine(cuisineName);
            map.put("cuisineName", cuisineName);
            System.out.println("Menus:" + menus);
            map.put("menus", menus);
            return new ModelAndView(map, "menu.ftl");
        }, new FreeMarkerEngine());
        before("/", (req, res) -> {
            User user = getAuthenticatedUser(req);
            if (user == null) {
                res.redirect("/public");
                halt();
            }
        });

        get("/menu/:cuisineName/order", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            String cuisineName = new String(req.params(":cuisineName"));
            map.put("cuisineName", cuisineName);
            return new ModelAndView(map, "order-form.ftl");
        }, new FreeMarkerEngine());

        post("/menu/:cuisineName/order", (req, res) -> {
            Map<String, Object> map = new HashMap<>();

            return new ModelAndView(map, "mainpage.ftl");
        }, new FreeMarkerEngine());
        		/*
		 * Displays the latest messages of all users.
		 */
        get("/public", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "mainpage.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Displays a user's tweets.
		 */
        get("/t/:username", (req, res) -> {
            String username = req.params(":username");
            User profileUser = service.getUserByUserName(username);

            User authUser = getAuthenticatedUser(req);
            boolean followed = false;
            List<Order> orders = service.getAllOrders(profileUser.getUserName());

            Map<String, Object> map = new HashMap<>();
            map.put("pageTitle", username + "'s Orders");
            map.put("user", authUser);
            map.put("profileUser", profileUser);
            map.put("orders", orders);
            return new ModelAndView(map, "order.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Checks if the user exists
		 */
        before("/t/:username", (req, res) -> {
            String username = req.params(":username");
            User profileUser = service.getUserByUserName(username);
            if(profileUser == null) {
                halt(404, "User not Found");
            }
        });



		/*
		 * Presents the login form or redirect the user to
		 * her timeline if it's already logged in
		 */
        get("/login", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            if(req.queryParams("r") != null) {
                map.put("message", "You were successfully registered and can login now");
            }
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Logs the user in.
		 */
        post("/login", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            User user = new User();
            try {
                MultiMap<String> params = new MultiMap<String>();
                UrlEncoded.decodeTo(req.body(), params, "UTF-8");
                BeanUtils.populate(user, params);
            } catch (Exception e) {
                halt(501);
                return null;
            }
            LoginResult result = service.checkUser(user);
            if(result.getUser() != null) {
                addAuthenticatedUser(req, result.getUser());
                res.redirect("/");
                halt();
            } else {
                map.put("error", result.getError());
            }
            map.put("username", user.getUserName());
            return new ModelAndView(map, "login.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Checks if the user is already authenticated
		 */
        before("/login", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });


		/*
		 * Presents the register form or redirect the user to
		 * her timeline if it's already logged in
		 */
        get("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "register.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Registers the user.
		 */
        post("/register", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            User user = new User();
            try {
                MultiMap<String> params = new MultiMap<String>();
                UrlEncoded.decodeTo(req.body(), params, "UTF-8");
                BeanUtils.populate(user, params);
            } catch (Exception e) {
                halt(501);
                return null;
            }
            String error = user.validate();
            if(StringUtils.isEmpty(error)) {
                User existingUser = service.getUserByUserName(user.getUserName());
                if(existingUser == null) {
                    service.registerUser(user);
                    res.redirect("/login?r=1");
                    halt();
                } else {
                    error = "The username is already taken";
                }
            }
            map.put("error", error);
            map.put("username", user.getUserName());
            map.put("email", user.getEmail());
            return new ModelAndView(map, "register.ftl");
        }, new FreeMarkerEngine());
		/*
		 * Checks if the user is already authenticated
		 */
        before("/register", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if(authUser != null) {
                res.redirect("/");
                halt();
            }
        });


		/*
		 * Registers a new message for the user.
		 */
        post("/order", (req, res) -> {
            User user = getAuthenticatedUser(req);
            MultiMap<String> params = new MultiMap<String>();
            UrlEncoded.decodeTo(req.body(), params, "UTF-8");
            Order order = new Order();
            //BeanUtils.populate(order, params);
            service.addOrder(order);
            res.redirect("/");
            return null;
        });
		/*
		 * Checks if the user is authenticated
		 */
        before("/order", (req, res) -> {
            User authUser = getAuthenticatedUser(req);
            if(authUser == null) {
                res.redirect("/login");
                halt();
            }
        });


		/*
		 * Logs the user out and redirects to the public timeline
		 */
        get("/logout", (req, res) -> {
            removeAuthenticatedUser(req);
            res.redirect("/public");
            return null;
        });
    }

    private void addAuthenticatedUser(Request request, User u) {
        request.session().attribute(USER_SESSION_ID, u);

    }

    private void removeAuthenticatedUser(Request request) {
        request.session().removeAttribute(USER_SESSION_ID);

    }

    private User getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }

    private void addSelectedCuisine(Request request, String cuisineName) {
        request.session().attribute(SELECTED_CUISINE, cuisineName);

    }

    private void removeSelectedCuisine(Request request) {
        request.session().removeAttribute(SELECTED_CUISINE);

    }


    private String getSelectedCuisine(Request request) {
        return request.session().attribute(SELECTED_CUISINE);
    }
}
