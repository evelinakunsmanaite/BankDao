/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Customer;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface CustomerDao {
    int create(Customer сustomer);

    Set<Customer> read();

    int update(Customer сustomer);

    int delete(Customer сustomer);
}
