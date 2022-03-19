package ru.javarush.kozlovskyi.cryptoanalizer.entity;

public class Results {

    public String message;
    public ResultCode resultCode;

    public Results(String message, ResultCode resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }


}
