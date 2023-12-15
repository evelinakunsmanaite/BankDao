package com.model;

public class Customer {

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private long creditCardNumber;
    private long bankAccountNumber;
    private int cardbalance;

    public Customer(int id, String lastName, String firstName, String middleName, String address, long creditCardNumber, long bankAccountNumber, int cardbalance) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.cardbalance = cardbalance;
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long interbankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getCardbalance() {
        return cardbalance;
    }

    public void setCardbalance(int cardbalance) {
        this.cardbalance = cardbalance;
    }

    @Override
    public String toString() {
        return String.format("%d; %s %s %s %s %d; %d %d ", id, lastName, firstName, middleName, address,
                creditCardNumber, bankAccountNumber, cardbalance);

    }
}
