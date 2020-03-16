package com.acejones;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branchArrayList = new ArrayList<Branch>();

    public ArrayList<Branch> getBranchArrayList() {
        return branchArrayList;
    }

    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) == null) {
            Branch newBranch = new Branch(branchName);
            this.branchArrayList.add(newBranch);
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String customerName, String branchName, double initialTransaction) {
        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            branch.addNewCustomer(customerName, initialTransaction);
            return true;
        } else {
            System.out.println("Branch does not exist.");
            return false;
        }
    }

    public boolean addNewTransaction(String customerName, String branchName, double transactionAmount) {
        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            branch.addTransaction(customerName, transactionAmount);
            return true;
        } else {
            System.out.println("Branch does not exist.");
            return false;
        }
    }

    public boolean printBranchCustomerList(String branchName) {
        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            System.out.println(branch.getName() + " Customers: ");
            for (int i = 0; i < branch.getCustomerArrayList().size(); i++) {
                System.out.println((i + 1) + ". " + branch.getCustomerArrayList().get(i).getName());
            }
            return true;
        } else {
            System.out.println("Branch does not exist.");
            return false;
        }
    }

    public boolean printCustomerTransactionList(String branchName, String customerName) {
        if (findBranch(branchName) != null) {
            Branch branch = findBranch(branchName);
            branch.printCustomerTransactions(customerName);
            return true;
        } else {
            System.out.println("Branch does not exist.");
            return false;
        }
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branchArrayList.size(); i++) {
            if (this.branchArrayList.get(i).getName().equals(branchName)) {
                return this.branchArrayList.get(i);
            }
        }
        return null;
    }
}
