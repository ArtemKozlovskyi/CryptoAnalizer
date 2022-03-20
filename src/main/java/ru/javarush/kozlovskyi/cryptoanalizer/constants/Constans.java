package ru.javarush.kozlovskyi.cryptoanalizer.constants;

import java.io.File;

public class Constans {
    //public static int key;
    public static String rus = "ЙЦУКЕЁНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    public static String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public static String cypher = "0123456789";
    public static String symbols = "-!() .,\"':;?";
    public static String ALPHABET = rus + eng + rus.toLowerCase() + eng.toLowerCase() + cypher + symbols;
    public static char[] alphabet = ALPHABET.toCharArray();
    public static int keyAlphabet = rus.length() + eng.length() + rus.toLowerCase().length()
            + eng.toLowerCase().length() + cypher.length() + symbols.length();
    public static final String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
}
