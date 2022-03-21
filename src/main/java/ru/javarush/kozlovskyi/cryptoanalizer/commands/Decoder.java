package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultsCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

import java.io.*;
import java.util.Objects;

import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.*;
import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.TXT_FOLDER;


public class Decoder implements Action {

    @Override
    public Results execute(String[] parameters) throws AppExceptions {
        CharArrayWriter charWordAfterCoding = new CharArrayWriter();
        try (BufferedReader readerForInputPath = new BufferedReader(new FileReader(TXT_FOLDER + parameters[0]))) {
            char[] arrayTempAfter = new char[1];
            while (readerForInputPath.read(arrayTempAfter) != -1) {
                charWordAfterCoding.write(arrayTempAfter);
            }
        } catch (Exception e) {
            throw new AppExceptions("input filepath was wrong", e);
        }

        char[] wordAfterCoding = charWordAfterCoding.toString().toCharArray();
        int key = Integer.parseInt(parameters[2]);
        char[] wordBeforeCoding = new char[wordAfterCoding.length];

        for (int j = 0; j < wordAfterCoding.length; j++) {
            for (int k = 0; k < alphabet.length; k++) {
                if (Objects.equals(wordAfterCoding[j], alphabet[k])) {
                    wordBeforeCoding[j] = alphabet[((k + keyAlphabet) - key) % keyAlphabet];
                }
            }
        }
        CharArrayReader charWordBeforeCoding = new CharArrayReader(wordBeforeCoding);

        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter((TXT_FOLDER + parameters[1])))) {
            char[] arrayTempBefore = new char[1];
            while (charWordBeforeCoding.read(arrayTempBefore) != -1) {
                bufWriter.write(arrayTempBefore);
            }
        } catch (Exception e) {
            throw new AppExceptions("outnput filepath was wrong", e);
        }


        return new Results("decode all right", ResultsCode.OK);
    }
}

