package com.acejones;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customerArrayList = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public boolean addNewCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            Customer newCustomer = new Customer(customerName, initialTransaction);
            this.customerArrayList.add(newCustomer);
            return true;
        } else {
            System.out.println("Customer already exists.");
            return false;
        }
    }

    public boolean addTransaction(String customerName, double transactionAmount) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(transactionAmount);
            return true;
        } else {
            return false;
        }
    }

    public boolean printCustomerTransactions(String customerName) {
        if (findCustomer(customerName) != null) {
            Customer customer = findCustomer(customerName);
            System.out.println(customerName + "'s Transactions: ");
            for (int i = 0; i < customer.getTransactionList().size(); i++) {
                System.out.println((i + 1) + ". " + customer.getTransactionList().get(i));
            }
            return true;
        } else {
            System.out.println("Customer does not exist.");
            return false;
        }
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < this.customerArrayList.size(); i++) {
            if (this.customerArrayList.get(i).getName().equals(customerName)) {
                return this.customerArrayList.get(i);
            }
        }
        return null;
    }
}
