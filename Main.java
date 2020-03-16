package com.acejones;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        int choice = 0;
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    createNewBranch();
                    break;
                case 2:
                    createNewCustomer();
                    break;
                case 3:
                    addCustomerTransaction();
                    break;
                case 4:
                    printBranchCustomerList();
                    break;
                case 5:
                    printCustomerTransactionList();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - View Menu");
        System.out.println("\t 1 - Create new branch");
        System.out.println("\t 2 - Create new customer");
        System.out.println("\t 3 - Add customer transaction");
        System.out.println("\t 4 - Print a branch's customers");
        System.out.println("\t 5 - Print a customer's transaction records");
        System.out.println("\t 6 - Exit");
    }

    private static void createNewBranch() {
        System.out.println("Enter new branch's name: ");
        String branchName = scanner.nextLine();
        if (bank.addNewBranch(branchName)) {
            System.out.println(branchName + " branch created.");
        } else {
            System.out.println("Branch already exists.");
        }
    }

    private static void createNewCustomer() {
        System.out.println("Enter the customer's desired branch: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter the customer's name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter the initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        if (bank.addNewCustomer(customerName, branchName, initialDeposit)) {
            System.out.println(customerName + " now has an account with " + initialDeposit);
        } else {
            System.out.println("New customer creation failed.");
        }
    }

    private static void addCustomerTransaction() {
        System.out.println("Enter customer's branch: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer's name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        double transactionAmount = scanner.nextDouble();
        if (bank.addNewTransaction(customerName, branchName, transactionAmount)) {
            System.out.println("Transaction of " + transactionAmount + " added to " + customerName + "'s account.");
        } else {
            System.out.println("New transaction failed.");
        }
    }

    private static void printBranchCustomerList() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        if (!bank.printBranchCustomerList(branchName)) {
            System.out.println("Customer list error. ");
        }
    }

    private static void printCustomerTransactionList() {
        System.out.println("Enter customer's branch: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer's name: ");
        String customerName = scanner.nextLine();
        if (!bank.printCustomerTransactionList(branchName, customerName)) {
            System.out.println("Transaction list error. ");
        }
    }
}
