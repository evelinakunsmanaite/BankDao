/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Customer;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface CustomerService {
    boolean create(Customer сustomer);

    Set<Customer> read();

    boolean update(int id, String lastName, String firstName, String middleName, String address, long creditCardNumber, long bankAccountNumber, int cardbalance);

    boolean delete(int id);
    
    List<Customer> getCustomerByCrdbalance (int cardbalance);
    
    List<Customer> getCustomerByCreditCardNumber(long start, long end);
    
    List<Customer> findCustomerById(int id);
}
