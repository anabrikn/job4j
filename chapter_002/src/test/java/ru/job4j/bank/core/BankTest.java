package ru.job4j.bank.core;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.ArrayList;

import ru.job4j.bank.parts.Account;
import ru.job4j.bank.parts.User;

public class BankTest {
    Bank bank = new Bank();

    @Test
    public void whenAddUser() {
        bank.addUser(new User("Ava", "57575757"));
        assertTrue(bank.isUserContain(new User("Ava", "57575757")));
    }

    @Test
    public void whenDeleteUser() {
        bank.addUser(new User("Ava", "57575757"));
        bank.deleteUser(new User("Ava", "57575757"));
        assertFalse(bank.isUserContain(new User("Ava", "57575757")));
    }

    @Test
    public void whenAddAccountToUser() {
        bank.addUser(new User("Ava", "57575757"));
        String requisites = "12344321";
        bank.addAccountToUser("57575757", new Account(100, requisites));
        assertTrue(bank.isAccountContain("57575757", requisites));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        bank.addUser(new User("Ava", "57575757"));
        Account acc1 = new Account(1000, "12344321");
        Account acc2 = new Account(1000, "43211234");
        Account acc3 = new Account(1000, "12341234");
        bank.addAccountToUser("57575757", acc1);
        bank.addAccountToUser("57575757", acc2);
        bank.addAccountToUser("57575757", acc3);
        bank.deleteAccountFromUser("57575757", new Account(1000, "43211234"));
        assertFalse(bank.isAccountContain("57575757", "43211234"));
    }

    @Test
    public void whenGetUserAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1000, "12344321"));
        accounts.add(new Account(1000, "43211234"));
        bank.addUser(new User("Ava", "57575757"));
        bank.addAccountToUser("57575757", new Account(1000, "12344321"));
        bank.addAccountToUser("57575757", new Account(1000, "43211234"));
        assertThat(bank.getUserAccounts("57575757"), is(accounts));
    }

    @Test
    public void whenTransferWhenMoneyIsEnough() {
        bank.addUser(new User("Ava", "57575757"));
        String reqSend = "12344321";
        String reqDest = "43211234";
        bank.addAccountToUser("57575757", new Account(1000, reqSend));
        bank.addAccountToUser("57575757", new Account(1000, reqDest));
        boolean result = bank.transferMoney("57575757", reqSend, "57575757", reqDest, 1000);
        assertTrue(result);
    }

    @Test
    public void whenTransferWhenMoneyIsNotEnough() {
        bank.addUser(new User("Ava", "57575757"));
        String reqSend = "12344321";
        String reqDest = "43211234";
        bank.addAccountToUser("57575757", new Account(1000, reqSend));
        bank.addAccountToUser("57575757", new Account(1000, reqDest));
        boolean result = bank.transferMoney("57575757", reqSend, "57575757", reqDest, 1001);
        assertFalse(result);
    }
}
