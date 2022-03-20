package ru.javarush.kozlovskyi.cryptoanalizer.entity;

import ru.javarush.kozlovskyi.cryptoanalizer.commands.Action;

import java.util.Arrays;

public class Results {

    public String message;
    public ResultsCode resultCode;
    //public String wordAfterCoding;

    public Results(String message, ResultsCode resultCode) {
        this.message = message;
        this.resultCode = resultCode;
    }

//    public Results(String message, ResultsCode resultCode, String wordAfterCoding) {
//        this.message = message;
//        this.resultCode = resultCode;
//        this.wordAfterCoding = wordAfterCoding;
//    }

    @Override
    public String toString() {
        return "Results{" +
                "message='" + message + '\'' +
                ", resultCode=" + resultCode + "}";
    }







}
