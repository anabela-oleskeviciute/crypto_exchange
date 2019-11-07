package com.company;

import com.company.transactions.AddMoney;
import com.company.transactions.Transaction;
import com.company.users.User;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        List<User> users = new ArrayList<>();
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //System.out.println("Kuriame vartotoja");
                    System.out.println("Iveskite savo varda:");
                    String name = scanner.next();
                    System.out.println("Iveskite savo balansa:");
                    double balance = scanner.nextDouble();
                    User user = new User(name, balance);
                    users.add(user);
                    break;
                case 2:
                    System.out.println("Vartotoju sarasas: ");
                    printUsers(users);
                    break;
                case 0:
                    System.out.println("Baigiame darba");
                    break;
                case 3:
                    printUsers(users);
                    System.out.println("Kuri vartotoja norite istrinti?");
                    int index = scanner.nextInt();
                    users.remove(index - 1);
                    printUsers(users);
                    break;
                case 4:
                    printUsers(users);
                    System.out.println("Iveskite saskaitos numeri is kurio darysite pavedima");
                    String accountFrom = scanner.next();

                    System.out.println("Iveskite saskaitos numeri i kuria darysite pavadinima");
                    String accountTo = scanner.next();
                    System.out.println("Iveskite suma kuria norite pervesti");
                    double amount = scanner.nextDouble();
                    User from = null;
                    User to = null;
                    for (User u : users) {
                        if (u.getAccountNumber().equals(accountFrom)) {
                            from = u;

                        }
                        if (u.getAccountNumber().equals(accountTo)) {
                            to = u;

                        }
                    }
                    users.remove(from);
                    users.remove(to);
                    Transaction transaction = new Transaction(from, to, amount);
                    List<User> transactedUsers = transaction.execute().stream()
                            .filter(u -> u != null)
                            .collect(Collectors.toList());

                    users.addAll(transactedUsers);
                    break;
                case 5:
                    printUsers(users);
                    System.out.println("Iveskite saskaitos numeri i kuria norite inesti pinigus");
                    String accountAdd = scanner.next();
                    System.out.println("Kiek pinigu norite inesti");
                    double amountAdd = scanner.nextDouble();
                    User add = null;
                    for (User u : users) {
                        if (u.getAccountNumber().equals(accountAdd)) {
                            add = u;
                        }
                    }
                    users.remove(add);
                    AddMoney addMoney = new AddMoney(add,amountAdd);
                    User newUser = addMoney.addMoney();
                    users.add(newUser);
                default:
                    System.out.println("Bloga ivestis");
            }

        } while (choice != 0);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Sukurti vartotoja");
        System.out.println("2. Perziureti vartotojus");
        System.out.println("3. Istrinti vartotoja");
        System.out.println("4. Daryti pavedima");
        System.out.println("5. Inesti pinigus");
        System.out.println("---------------------------");
        System.out.println("0. Baigti");
    }

    public static void printUsers(List<User> users) {
        int i = 1;
        for (User u : users) {
            System.out.println(i + ". " + u.toString());
            i++;
        }
    }
}



