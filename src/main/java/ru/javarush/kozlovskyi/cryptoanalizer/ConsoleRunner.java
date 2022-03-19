package ru.javarush.kozlovskyi.cryptoanalizer;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

public class ConsoleRunner {

    public static void main(String[] args) {
        // encode text.txt encode.txt 12
        Application application = new Application();
        Results result  = application.run(args);
        System.out.println(result);

    }
}
//        int key = 123; // from argument
//        String text = "Привет медвед!";
//        String result  = "...............";