package com.acejones;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionList = new ArrayList<Double>();

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactionList.add(initialTransaction);
    }

    public void addTransaction(double newTransaction) {
        this.transactionList.add(newTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionList() {
        return transactionList;
    }
}
