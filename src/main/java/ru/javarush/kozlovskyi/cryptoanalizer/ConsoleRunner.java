package ru.javarush.kozlovskyi.cryptoanalizer;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.Result;

import java.util.Arrays;

public class ConsoleRunner {
    public static void main(String[] args) {



        Application application = new Application();
        Result result  = application.run(args);

        System.out.println(result);
    }
}
//        int key = 123; // from argument
//        String text = "Привет медвед!";
//        String result  = "...............";