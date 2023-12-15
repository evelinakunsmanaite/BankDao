/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDao dao;

    public CustomerServiceImpl(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean create(Customer сustomer) {
        return dao.create(сustomer) > 0;
    }

    @Override
    public Set<Customer> read() {
        return dao.read();
    }

    @Override
    public boolean update(int id, String lastName, String firstName, String middleName, String address, long creditCardNumber, long bankAccountNumber, int cardbalance) {
        Customer сustomers = new Customer(id, lastName, firstName, middleName, address, creditCardNumber, bankAccountNumber, cardbalance);
        return dao.update(сustomers) > 0;
    }

    @Override
    public boolean delete(int id) {
        Customer сustomers = new Customer(id);
        return dao.delete(сustomers) > 0;
    }

    @Override
    public List<Customer> getCustomerByCrdbalance(int cardbalance) {
        return dao.read().stream()
                .filter(customer -> customer.getCardbalance() > cardbalance)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomerByCreditCardNumber(long start, long end) {
        return dao.read().stream()
                .filter(customer -> customer.getCreditCardNumber() >= start && customer.getCreditCardNumber() <= end)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findCustomerById(int id) {
        return dao.read().stream()
                .filter(customer -> customer.getId() == id)
                .collect(Collectors.toList());
    }
}
