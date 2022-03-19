package ru.javarush.kozlovskyi.cryptoanalizer;

import ru.javarush.kozlovskyi.cryptoanalizer.controllers.MainContriller;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

import java.util.Arrays;

public class Application {

    private final MainContriller mainContriller;

    public Application() {

        mainContriller = new MainContriller();
    }

    public Results run(String[] args){
        // encode text.txt encode.txt 12

        if (args.length > 0) {
            String action = args[0];  // encode
            // parametrs  text.txt encode.txt 12
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            return mainContriller.doAction(action, parameters);
        } else {
            throw new AppExceptions("not argumens ");
        }


    }

}
