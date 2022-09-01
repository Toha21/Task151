package ru.netology;

public class AlreadyExistsException extends Throwable {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
