package com.company.transactions;

import com.company.users.User;

import javax.security.auth.login.AccountException;

public class AddMoney {
    private User accountAdd;
    private double amountAdd;

    public AddMoney(User accountAdd, double amountAdd) {
        this.accountAdd = accountAdd;
        this.amountAdd = amountAdd;
    }
    public User addMoney () {
        accountAdd.setBalance(accountAdd.getBalance()+amountAdd);
        return accountAdd;
    }
}
