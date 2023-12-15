/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Customer;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ReadServlet", urlPatterns = {"/ReadServlet"})
public class ReadServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<Customer> customer = customerService.read();// Получение списка абитуриентов из сервиса

         if (!customer.isEmpty()) {
            request.setAttribute("customer", customer);
            jump("/WEB-INF/jsp/adminRead.jsp", request, response);
        } else {

            Locale userLocale = request.getLocale();

            ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

            String failureMessage = bundle.getString("error.dataNotExist");

            request.setAttribute("error2", failureMessage);
            jump("/WEB-INF/jsp/error2.jsp", request, response);
        }

    }

}
