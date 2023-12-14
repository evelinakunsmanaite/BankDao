//package com.controller;
//
//import com.model.Customer;
//import com.model.CustomerList;
//import java.io.IOException;
//import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet"})
//public class ListServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Customer[] customers = CustomerList.getCustomers();
//        ArrayList<Customer> result = new ArrayList<>();
//        // Добавление всех клиентов в результат и вывод информации о каждом клиенте в консоль
//        for (Customer customer : customers) {
//
//            result.add(customer);
//            System.out.println(customer);
//        }
//
//        request.setAttribute("result", result);
//        RequestDispatcher rd = getServletContext()
//                .getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//        rd.forward(request, response);
//    }
//}
