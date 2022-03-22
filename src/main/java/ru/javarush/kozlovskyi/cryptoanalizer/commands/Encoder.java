package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.ConsoleRunner;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultsCode;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

import java.io.*;
import java.util.Objects;

import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.*;


public class Encoder implements Action {

    @Override
    public Results execute(String[] parameters) throws AppExceptions {

        CharArrayWriter charWordBeforeCoding = new CharArrayWriter();
        try (BufferedReader readerForInputPathreader = new BufferedReader(new FileReader(TXT_FOLDER + parameters[0]))) {
            char[] array = new char[1];
            while (readerForInputPathreader.read(array) != -1) {
                charWordBeforeCoding.write(array);
            }
        } catch (Exception e) {
            throw new AppExceptions("input filepath was wrong", e);
        }
        charWordBeforeCoding.close();

        char[] wordBeforeCoding = charWordBeforeCoding.toString().toCharArray();
        int key = Integer.parseInt(parameters[2]);
        char[] wordAfterCoding = new char[wordBeforeCoding.length];

        for (int j = 0; j < wordBeforeCoding.length; j++) {
            for (int k = 0; k < alphabet.length; k++) {
                if (Objects.equals(wordBeforeCoding[j], alphabet[k])) {
                    wordAfterCoding[j] = alphabet[(k + key) % keyAlphabet];
                }
            }
        }

        try (BufferedWriter writeCharWordAfterCoding = new BufferedWriter(new FileWriter((TXT_FOLDER + parameters[1])));
            CharArrayReader charArrayReader = new CharArrayReader(wordAfterCoding)) {
            char[] charWordAfterCoding = new char[1];
            while (charArrayReader.read(charWordAfterCoding) != -1) {
                writeCharWordAfterCoding.write(charWordAfterCoding);
            }
        } catch (Exception e) {
            throw new AppExceptions("input filepath was wrong", e);
        }

        return new Results("encode all right", ResultsCode.OK);
    }

}
