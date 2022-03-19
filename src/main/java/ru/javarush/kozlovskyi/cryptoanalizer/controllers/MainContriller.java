package ru.javarush.kozlovskyi.cryptoanalizer.controllers;

import ru.javarush.kozlovskyi.cryptoanalizer.commands.Action;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

public class MainContriller {

    public Results doAction(String actionName, String[] parameters){
        // action == encode
        // parametrs ==  [text.txt encode.txt 12]
        Action action = Actions.find(actionName);
        Results result = action.execute(parameters);
        return result;
    }

}
