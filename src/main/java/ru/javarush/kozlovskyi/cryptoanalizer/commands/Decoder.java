package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;



public class Decoder implements Action{

    @Override
    public Results execute(String[] parameters) {

        return new Results("decode all right", ResultCode.OK);
    }
}

