//package com.controller;
//
//import com.model.Customer;
//import java.io.IOException;
//import com.model.CustomerList;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "CreditCardNumberServlet", urlPatterns = {"/CreditCardNumberServlet"})
//public class CreditCardNumberServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//
//            Customer[] customers = CustomerList.getCustomers();
//            ArrayList<Customer> result = new ArrayList<>();
//            // Получение начального и конечного значений номеров кредитных карт из параметров запроса
//            long start = Long.parseLong(request.getParameter("start"));
//            long end = Long.parseLong(request.getParameter("end"));
//
//            // Поиск клиентов по номеру кредитной карты
//            for (Customer customer : customers) {
//                if (customer.getCreditCardNumber() >= start && customer.getCreditCardNumber() <= end) {
//                    result.add(customer);
//                }
//            }
//
//            request.setAttribute("result", result);
//            RequestDispatcher rd = getServletContext()
//                    .getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//            rd.forward(request, response);
//        } catch (IOException | NumberFormatException | ServletException e) {
//            request.setAttribute("error2", "Ошибка ввода данных");
//            RequestDispatcher rd = getServletContext()
//                    .getRequestDispatcher("/WEB-INF/jsp/error2.jsp");
//            rd.forward(request, response);
//        }
//    }
//}
