package com.company.users;

import java.util.Random;

public class User {
    private String name;
    private double balance;
    private String accountNumber;
    private int credit ;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        Random random = new Random();
        this.accountNumber = "LT" + (random.nextInt(99999 - 10000) + 10000);
        this.credit = 600;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
