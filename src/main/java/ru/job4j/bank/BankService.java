package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if ((user != null) && !(users.get(user).contains(account))) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account acc : users.get(findByPassport(passport))) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
        double destBalance = findByRequisite(destPassport, destRequisite).getBalance();

        if (srcBalance >= amount) {
            findByRequisite(destPassport, destRequisite).setBalance(destBalance + amount);
            findByRequisite(srcPassport, srcRequisite).setBalance(srcBalance - amount);
           return true;
        }
        return rsl;
    }
}