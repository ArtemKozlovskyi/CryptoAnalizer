package ru.javarush.kozlovskyi.cryptoanalizer.constants;

import java.io.File;
import java.nio.channels.FileChannel;

public class Constans {
    public static int key;
    public static String rus = "ЙЦУКЕЁНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    public static String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public static String cypher = "0123456789";
    public static String z = "-!@#$%^&*()[]{} .,:;?";
    public static String ALPHABET = rus + eng + rus.toLowerCase() + eng.toLowerCase() + cypher + z;
    public static char[] alphabet = ALPHABET.toCharArray();
    public static int keyAlphabet = rus.length() + eng.length() + rus.toLowerCase().length()
            + eng.toLowerCase().length() + cypher.length() + z.length();
    public static final String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
}
