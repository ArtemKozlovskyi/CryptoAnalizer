package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

import java.io.IOException;

public interface Action {

    Results execute(String[] parameters) throws IOException;

}
