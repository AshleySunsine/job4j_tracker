package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<Account>();
        for (Account account : accounts) {
            rsl.add(account);
        }
        return rsl;
    }
}