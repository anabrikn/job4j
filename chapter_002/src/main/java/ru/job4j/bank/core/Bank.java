package ru.job4j.bank.core;

import ru.job4j.bank.exceptions.ContainsException;
import ru.job4j.bank.exceptions.TransferException;
import ru.job4j.bank.parts.Account;
import ru.job4j.bank.parts.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private TreeMap<User, ArrayList<Account>> bank = new TreeMap<>();

    public TreeMap<User, ArrayList<Account>> getBankData() {
        return bank;
    }

    public void addUser(User user) throws ContainsException {
        if (user != null && !bank.containsKey(user)) {
            this.bank.put(user, new ArrayList<Account>());
        } else {
            throw new ContainsException("Такой пользователь уже есть в базе или переданы некорректные данные.");
        }
    }

    public void deleteUser(User user) throws ContainsException {
        if (user != null && bank.containsKey(user)) {
            this.bank.remove(user);
        } else {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные.");
        }
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null && account != null) {
            bank.get(user).add(account);
        } else {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные аккаунта.");
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null && account != null) {
            bank.get(user).remove(account);
        } else {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные аккаунта.");
        }
    }

    public List<Account> getUserAccounts(String passport) throws ContainsException {
        User user = findUserByPassport(passport);
        ArrayList<Account> list;
        if (user != null && bank.get(user) != null) {
            list = bank.get(user);
        } else {
            list = new ArrayList<>();
            throw new ContainsException("Все пропало!");
        }
        return list;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) throws TransferException {
        boolean result = false;
        User user1 = findUserByPassport(srcPassport);
        User user2 = findUserByPassport(destPassport);
        Account account1 = findAccountByUserAndRequisite(user1, srcRequisite);
        Account account2 = findAccountByUserAndRequisite(user2, dstRequisite);
        if (account1.getValue() > amount) {
            account1.setValue(account1.getValue() - amount);
            account2.setValue(account2.getValue() + amount);
            result = true;
        }
        return result;
    }

    private User findUserByPassport(String pass) throws ContainsException {
        User u = null;
        for (Map.Entry<User, ArrayList<Account>> entry : bank.entrySet()) {
            if (entry.getKey().getPassport().equals(pass)) {
                u = entry.getKey();
            }
        }
        if (u != null) {
            return u;
        } else {
            throw new ContainsException("Такого пользователя нет в базе или переданы некорректные данные.");
        }

    }

    private Account findAccountByRequisit(String req) throws ContainsException {
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

    private Account findAccountByUserAndRequisite(User usr, String req) throws ContainsException {
        Account a = null;
        if (bank.containsKey(usr)) {
            for (Account array : bank.get(usr)) {
                if (array.getRequisites().equals(req)) {
                    a = array;
                }
            }
            if (a != null) {
                return a;
            } else {
                throw new ContainsException("Такого аккаунта не существует или переданы некорректные данные.");
            }
        } else {
            throw new ContainsException("Такого аккаунта не существует или он не пренадлежит этому юзеру.");
        }
    }
}