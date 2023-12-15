/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Customer;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/adminAdd.jsp", request, response);
    }//сработывает при нажатии на ссылку добавить 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String address = request.getParameter("address");
        Long creditCardNumber = Long.valueOf(request.getParameter("creditCardNumber"));
        Long bankAccountNumber = Long.valueOf(request.getParameter("bankAccountNumber"));
        int cardbalance = Integer.parseInt(request.getParameter("cardbalance"));

        // Создаем объект абитуриента
        Customer сustomer = new Customer(lastName, firstName, middleName, address, creditCardNumber, bankAccountNumber, cardbalance);

        boolean isPatientAdd = customerService.create(сustomer);
        Locale userLocale = request.getLocale();

        ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

        String successMessage = bundle.getString("error.dataAdded");
        String failureMessage = bundle.getString("error.dataNotAdded");

        request.setAttribute("error", isPatientAdd ? successMessage : failureMessage);

        jump("/WEB-INF/jsp/error.jsp", request, response);

    }
}
