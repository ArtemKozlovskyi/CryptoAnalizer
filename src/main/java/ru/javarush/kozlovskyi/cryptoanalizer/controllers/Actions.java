package ru.javarush.kozlovskyi.cryptoanalizer.controllers;

import ru.javarush.kozlovskyi.cryptoanalizer.commands.Action;
import ru.javarush.kozlovskyi.cryptoanalizer.commands.BrudeForce;
import ru.javarush.kozlovskyi.cryptoanalizer.commands.Decoder;
import ru.javarush.kozlovskyi.cryptoanalizer.commands.Encoder;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

public enum Actions {
    DECODE(new Decoder()),
    ENCODE(new Encoder()),
    BRUDEFORCE(new BrudeForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }


    public static Action find(String actionName){
        try{

            Actions value = Actions.valueOf(actionName.toUpperCase());
            Action action = value.action;
            return action;
        } catch (IllegalArgumentException e) {
            throw new AppExceptions("not found " + actionName, e);
        }
    }


}
