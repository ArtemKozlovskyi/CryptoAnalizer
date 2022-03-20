package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.ConsoleRunner;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultsCode;

import java.io.*;
import java.util.Objects;

import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.*;


public class Encoder implements Action{

    @Override
    public Results execute(String[] parameters) throws IOException {

        BufferedReader reader = new BufferedReader( new FileReader(TXT_FOLDER + parameters[0]));
        CharArrayWriter charArrayWriter =  new CharArrayWriter();

            char[] array = new char[1];
            while(reader.read(array)!=-1)
            {
                charArrayWriter.write(array);
            }

        charArrayWriter.close();
        reader.close();

        char[] wordBeforeCoding = charArrayWriter.toString().toCharArray();
        int key = Integer.parseInt(parameters[2]);
        char[] wordAfterCoding = new char[wordBeforeCoding.length];

        for (int j = 0; j < wordBeforeCoding.length; j++) {
            for (int k = 0; k < alphabet.length; k++) {
                if (Objects.equals(wordBeforeCoding[j], alphabet[k])) {
                    wordAfterCoding[j] = alphabet[(k + key) % keyAlphabet];
                }
            }
        }
        CharArrayReader charArrayReader = new CharArrayReader(wordAfterCoding);

        BufferedWriter bufWriter = new BufferedWriter(new FileWriter((TXT_FOLDER + parameters[1])));

            char[] tmp = new char[1];
            while(charArrayReader.read(tmp)!=-1)
            {
                bufWriter.write(tmp);
            }

        charArrayReader.close();
        bufWriter.flush();
        bufWriter.close();

        return new Results( "encode all right", ResultsCode.OK);
    }

}
