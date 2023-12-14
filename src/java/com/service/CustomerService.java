/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.Customer;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface CustomerService {
    boolean create(Customer сustomer);

    Set<Customer> read();

    boolean update();

    boolean delete(int id);
}
