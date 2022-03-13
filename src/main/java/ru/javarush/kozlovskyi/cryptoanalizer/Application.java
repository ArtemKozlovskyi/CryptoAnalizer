package ru.javarush.kozlovskyi.cryptoanalizer;

import ru.javarush.kozlovskyi.cryptoanalizer.controllers.MainContriller;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Result;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

import java.util.Arrays;

public class Application {

    private final MainContriller mainContriller;

    public Application() {
        mainContriller = new MainContriller();
    }

    public Result run(String[] args){
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            mainContriller.doAction(action, parameters);
        }
        throw new AppExceptions();

    }

}
