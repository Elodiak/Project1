package ru.javarush.kozhevnikova.cryptoalalizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnotherConstants {
    public static final String PATHOFFILE = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static int findKey(int key) {
        if (key > Alphabet.ALPHABET.length) {
            key = key % Alphabet.ALPHABET.length;
        }
        return key;
    }

    public static void checkDirectory() throws IOException {
        Path path = Path.of(AnotherConstants.PATHOFFILE);
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
        }
    }
}
