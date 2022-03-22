package ru.javarush.kozlovskyi.cryptoanalizer;

import ru.javarush.kozlovskyi.cryptoanalizer.commands.Decoder;
import ru.javarush.kozlovskyi.cryptoanalizer.commands.Encoder;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;

import java.io.IOException;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        // encode text.txt encode.txt 12
        Application application = new Application();
        Results result  = application.run(args);
        System.out.println(result);



    }
}
