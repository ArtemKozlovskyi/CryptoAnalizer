package ru.javarush.kozlovskyi.cryptoanalizer.commands;

import ru.javarush.kozlovskyi.cryptoanalizer.entity.ResultsCode;
import ru.javarush.kozlovskyi.cryptoanalizer.entity.Results;
import ru.javarush.kozlovskyi.cryptoanalizer.exceptions.AppExceptions;

import java.io.*;
import java.util.Objects;

import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.*;
import static ru.javarush.kozlovskyi.cryptoanalizer.constants.Constans.TXT_FOLDER;

public class BrudeForce implements Action {

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
        charWordAfterCoding.close();

        char[] wordAfterCoding = charWordAfterCoding.toString().toCharArray();
        char[] wordBeforeCoding = new char[wordAfterCoding.length];

        int tempKey = 0;
        int spasesValue = 0;

        for (int key = 0; key < 33; key++) {

            for (int j = 0; j < wordAfterCoding.length; j++) {
                for (int k = 0; k < alphabet.length; k++) {
                    if (Objects.equals(wordAfterCoding[j], alphabet[k])) {
                        wordBeforeCoding[j] = alphabet[((k + keyAlphabet) - key) % keyAlphabet];


                        if (Objects.equals((alphabet[((k + keyAlphabet) - key) % keyAlphabet]), alphabet[144])) {
                            spasesValue++;
                        }
                    }
                }

            }

            if ((wordAfterCoding.length / 7) <= spasesValue) {
                tempKey = key;
                break;
            }


        }

        int key = tempKey;

        for (int j = 0; j < wordAfterCoding.length; j++) {
            for (int k = 0; k < alphabet.length; k++) {
                if (Objects.equals(wordAfterCoding[j], alphabet[k])) {
                    wordBeforeCoding[j] = alphabet[((k + keyAlphabet) - key) % keyAlphabet];

                }
            }
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter((TXT_FOLDER + parameters[1])));
             CharArrayReader charWordBeforeCoding = new CharArrayReader(wordBeforeCoding)) {
            char[] arrayTempBefore = new char[1];
            while (charWordBeforeCoding.read(arrayTempBefore) != -1) {
                writer.write(arrayTempBefore);
            }
        } catch (Exception e) {
            throw new AppExceptions("outnput filepath was wrong", e);
        }

        return new Results("BrudeForce all right", ResultsCode.OK);
    }
}

