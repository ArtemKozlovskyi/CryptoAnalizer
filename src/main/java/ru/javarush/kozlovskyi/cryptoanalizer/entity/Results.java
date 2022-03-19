package ru.javarush.kozlovskyi.cryptoanalizer.entity;

public class Results {

    public String message;
    public ResultsCode resultCode;

    public Results(String message, ResultsCode resultsCode) {
        this.message = message;
        this.resultCode = resultsCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }


}
