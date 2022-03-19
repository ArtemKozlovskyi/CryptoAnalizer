package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultsCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;


public class Encoder implements Action{

    @Override
    public Results execute(String[] parameters) {

        return new Results("encode all right", ResultsCode.OK);
    }
}
