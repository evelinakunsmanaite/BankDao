/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Customer;
import java.io.IOException;
import java.util.HashSet;
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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Set<Customer> customers = customerService.read();// Получение списка абитуриентов из сервиса
        Set<Customer> customer = new HashSet<>();
        for (Customer a : customers) {
            if (a.getId() == Integer.parseInt(id)) {
                customer.add(a);
            }
        }

        request.setAttribute("customer", customer);
        jump("/WEB-INF/jsp/update.jsp", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String address = request.getParameter("address");
        Long creditCardNumber = Long.valueOf(request.getParameter("creditCardNumber"));
        Long bankAccountNumber = Long.valueOf(request.getParameter("bankAccountNumber"));
        int cardbalance = Integer.parseInt(request.getParameter("cardbalance"));

        boolean isCustomerUpdate = customerService.update(id, lastName, firstName, middleName, address, creditCardNumber, bankAccountNumber, cardbalance);

        Locale userLocale = request.getLocale();

        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        String successMessage = bundle.getString("error.dataUpdate");
        String failureMessage = bundle.getString("error.dataNotUpdate");

        request.setAttribute("error", isCustomerUpdate ? successMessage : failureMessage);

        jump("/WEB-INF/jsp/error.jsp", request, response);

    }

}
