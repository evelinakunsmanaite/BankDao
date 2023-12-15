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

@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet"})
public class ListServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Добавление всех клиентов в результат и вывод информации о каждом клиенте в консоль
        Set<Customer> result = customerService.read();

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
