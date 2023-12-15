package com.controller;

import com.model.Customer;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CardbalanceServlet", urlPatterns = {"/CardbalanceServlet"})
public class CardbalanceServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Получение значения баланса карты из параметра запроса
        int cardbalance = Integer.parseInt(request.getParameter("cardbalance"));
        // Поиск клиентов с балансом карты больше указанного значения
        List<Customer> result = customerService.getCustomerByCrdbalance(cardbalance);

        if (!result.isEmpty()) {
            request.setAttribute("result", result);
            jump("/WEB-INF/jsp/result.jsp", request, response);
        } else {

            Locale userLocale = request.getLocale();

            ResourceBundle bundle = ResourceBundle.getBundle("com.localization.messages.msg", userLocale);

            String failureMessage = bundle.getString("error.dataNotExist");

            request.setAttribute("error2", failureMessage);
            jump("/WEB-INF/jsp/error2.jsp", request, response);
        }

    }
}
