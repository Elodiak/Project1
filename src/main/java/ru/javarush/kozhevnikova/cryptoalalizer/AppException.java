package ru.javarush.kozhevnikova.cryptoalalizer;

public class AppException extends RuntimeException {


    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }
}
