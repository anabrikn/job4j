package ru.job4j.bank.exceptions;

public class ContainsException extends RuntimeException {
    public ContainsException(String message) {
        super(message);
    }
}
