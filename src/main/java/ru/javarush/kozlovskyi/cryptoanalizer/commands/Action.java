package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import javax.xml.transform.Result;

public interface Action {

    Result execute(String[] parameters);

}
