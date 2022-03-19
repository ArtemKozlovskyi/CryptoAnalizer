package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

import javax.xml.transform.Result;

public interface Action {

    Results execute(String[] parameters);

}
