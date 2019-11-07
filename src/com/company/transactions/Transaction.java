package com.company.transactions;

import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private User from;
    private User to;
    private double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    private boolean isValid() {
        return to != null && from != null && from.getBalance()/*+from.getCredit()*/ >= amount;
    }

    public List<User> execute() {
        List<User> transactedUsers = new ArrayList<>();
        if (isValid()) {
            if (from.getBalance() >= amount) {
                from.setBalance(from.getBalance() - amount);
                to.setBalance(to.getBalance() + amount);
            }
            /*if(from.getBalance()!=0) {
                int
            }
        } else {
            System.out.println("Transakcija nevalidi");
        }*/
            transactedUsers.add(from);
            transactedUsers.add(to);
            return transactedUsers;
        }


    }
