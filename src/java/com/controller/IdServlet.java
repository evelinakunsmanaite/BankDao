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
//@WebServlet(name = "IdServlet", urlPatterns = {"/IdServlet"})
//public class IdServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            // Получение значения ID клиента из параметра запроса
//            Customer[] customers = CustomerList.getCustomers();
//            ArrayList<Customer> result = new ArrayList<>();
//            int id = Integer.parseInt(request.getParameter("id"));
//            // Поиск клиента по ID
//            for (Customer customer : customers) {
//                if (customer.getId() == id) {
//                    result.add(customer);
//                    System.out.println(customer);
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
