/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.impl;

import com.dao.CustomerDao;
import com.model.Customer;
import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class CustomerDaoImpl implements CustomerDao {

    private final DataSource dataSource;

    public CustomerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(Customer сustomer) {
 try (Connection conn = dataSource.getConnection()) {//установление соединения (получение соединения)
            int id;

            String sql = "insert into customers(last_name, first_name, middle_name, address, credit_card_number, bank_account_number, cardbalance) values(?,?,?,?,?,?,?)";//формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {//в наш подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, сustomer.getLastName());
                preparedStatement.setString(2, сustomer.getFirstName());
                preparedStatement.setString(3, сustomer.getMiddleName());
                preparedStatement.setString(4, сustomer.getAddress());
                preparedStatement.setLong(5, сustomer.getCreditCardNumber());
                preparedStatement.setLong(6, сustomer.getBankAccountNumber());
                preparedStatement.setInt(7, сustomer.getCardbalance());

//переданный запрос меняем, указываем позицию ? и чем мы его занимаем, отсчёт с 1
                int affectedRows = preparedStatement.executeUpdate();//количество добавленных строчек

                if (affectedRows == 0) {// если строчки не добавлены выбрасывается исключение 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1;";//сортируем в обратном порядке записи(от максимального до минимального) в бд и получаем первую строчку
                try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) {//если результат имеет хотя бы 1у запись
                        id = rs.getInt("id"); //берём id свежесозданной строчки 
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public Set<Customer> read() {
        String req = "Select * from customers";
        Set<Customer> customers;
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(req)) {
                customers = new HashSet<>();
                while (resultSet.next()) {//пока есть записи 
                    int id = resultSet.getInt("id");
                    String lastName = resultSet.getString("last_name");
                    String firstName = resultSet.getString("first_name");
                    String middleName = resultSet.getString("middle_name");
                    String address = resultSet.getString("address");
                    long creditCardNumber = resultSet.getLong("credit_card_number");
                    long bankAccountNumber = resultSet.getLong("bank_account_number");
                    int cardbalance = resultSet.getInt("cardbalance");

                    customers.add(new Customer(id, lastName, firstName, middleName, address, creditCardNumber, bankAccountNumber, cardbalance));
                }
            }
            return customers;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Customer сustomer) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE customers SET last_name =?,first_name =?,middle_name =?,address =?,credit_card_number =?,bank_account_number =?,cardbalance =? WHERE id =?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, сustomer.getLastName());
                preparedStatement.setString(2, сustomer.getFirstName());
                preparedStatement.setString(3, сustomer.getMiddleName());
                preparedStatement.setString(4, сustomer.getAddress());
                preparedStatement.setLong(5, сustomer.getCreditCardNumber());
                preparedStatement.setLong(6, сustomer.getBankAccountNumber());
                preparedStatement.setInt(7, сustomer.getCardbalance());

                preparedStatement.setInt(8, сustomer.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Customer сustomer) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "delete from customers where id = ?";
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setInt(1, сustomer.getId());
                int result = preparedStmt.executeUpdate();
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
