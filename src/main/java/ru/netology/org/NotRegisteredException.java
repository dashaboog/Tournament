package ru.netology.org;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super(s);
    }
}
