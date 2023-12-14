package com.controller;

import com.dao.CustomerDao;
import com.dao.UserDao;
import com.dao.impl.CustomerDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.service.CustomerService;
import com.service.UserService;
import com.service.impl.CustomerServiceImpl;
import com.service.impl.UserServiceImpl;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

public abstract class InitServlet extends HttpServlet {

    private @Resource(name = "jdbc/GuestsDB")//испальзование листнера
    DataSource dataSource;
    protected UserDao userDao;
    protected CustomerDao customerDao;
    protected UserService userService;
    protected CustomerService customerService;

    @Override
    public void init() {//инициализация объектов с которыми работает сервлеты
        userDao = new UserDaoImpl(dataSource);
        userService = new UserServiceImpl(userDao);
        customerDao = new CustomerDaoImpl(dataSource);
        customerService = new CustomerServiceImpl(customerDao);
    }
}
