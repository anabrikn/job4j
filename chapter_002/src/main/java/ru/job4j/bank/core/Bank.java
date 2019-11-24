package ru.job4j.bank.core;

import ru.job4j.bank.exceptions.ContainsException;
import ru.job4j.bank.parts.Account;
import ru.job4j.bank.parts.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private TreeMap<User, ArrayList<Account>> bank = new TreeMap<>();

    public boolean isUserContain(User user) {
        return bank.containsKey(user);
    }

    public boolean isAccountContain(String pass, String req) {
        Account account = findAccountByPassportAndRequisite(pass, req);
        boolean result = false;
        if (account != null) {
            result = true;
        }
        return result;
    }

    public void addUser(User user) {
        if (user == null) {
            throw new ContainsException("Переданы некорректные данные.");
        }
        this.bank.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        if (!bank.containsKey(user)) {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные.");
        }
        this.bank.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user == null || account == null) {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные аккаунта.");
        }
        bank.get(user).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user == null || account == null) {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные аккаунта.");
        }
        bank.get(user).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        User user = findUserByPassport(passport);
        if (bank.get(user) == null) {
            return new ArrayList<>();
        }
        return bank.get(user);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account account1 = findAccountByPassportAndRequisite(srcPassport, srcRequisite);
        Account account2 = findAccountByPassportAndRequisite(destPassport, dstRequisite);
        if (account1 != null && account2 != null) {
            result = account1.transferTo(account2, amount);
        }
        return result;
    }

    private Account findAccountByPassportAndRequisite(String pass, String requisite) {
        User u = findUserByPassport(pass);
        Account a = null;
        if (bank.containsKey(u)) {
            for (Account array : bank.get(u)) {
                if (array.getRequisites().equals(requisite)) {
                    a = array;
                    break;
                }
            }
        }
        return a;
    }

    private User findUserByPassport(String pass) {
        User u = null;
        for (Map.Entry<User, ArrayList<Account>> entry : bank.entrySet()) {
            if (entry.getKey().getPassport().equals(pass)) {
                u = entry.getKey();
            }
        }
        return u;
    }

    private Account findAccountByRequisite(String req) throws ContainsException {
        Account a = null;
        for (Map.Entry<User, ArrayList<Account>> entry : bank.entrySet()) {
            for (Account account: entry.getValue()) {
                if (account.getRequisites().equals(req)) {
                    a = account;
                    break;
                }
            }
        }
        if (a != null) {
            return a;
        } else {
            throw new ContainsException("Такого аккаунта не существует или переданы некорректные данные.");
        }
    }
}