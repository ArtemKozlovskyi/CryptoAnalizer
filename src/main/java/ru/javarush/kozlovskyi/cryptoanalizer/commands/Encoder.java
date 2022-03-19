package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import javax.xml.transform.Result;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;


public class Encoder implements Action{

    @Override
    public Results execute(String[] parameters) {

        return new Results("encode all right", ResultCode.OK);
    }
}
