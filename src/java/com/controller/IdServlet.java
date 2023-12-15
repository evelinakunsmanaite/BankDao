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

@WebServlet(name = "IdServlet", urlPatterns = {"/IdServlet"})
public class IdServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // Получение значения ID клиента из параметра запроса
            int id = Integer.parseInt(request.getParameter("id"));
            // Поиск клиента по ID
            List<Customer> result = customerService.findCustomerById(id);

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
