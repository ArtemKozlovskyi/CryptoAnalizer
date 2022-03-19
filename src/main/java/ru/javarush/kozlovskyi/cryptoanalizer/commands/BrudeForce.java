package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

import javax.xml.transform.Result;

public class BrudeForce implements Action{
    @Override
    public Results execute(String[] parameters) {

        return new Results("drudeforce all right", ResultCode.OK);
    }
}
