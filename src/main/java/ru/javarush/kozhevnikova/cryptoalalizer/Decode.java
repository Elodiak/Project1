package ru.javarush.kozhevnikova.cryptoalalizer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Decode {

    public static char decryption(char c, int key) {
        for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
            if (Alphabet.ALPHABET[i] == c) {
                if (i - key <= 0) {
                    int num = key - i;
                    int num2 = Alphabet.ALPHABET.length - num;
                    c = Alphabet.ALPHABET[Alphabet.ALPHABET.length - num2];
                    break;
                } else {
                    c = Alphabet.ALPHABET[i - key];
                    break;
                }
            }
        }
        return c;
    }

    public static void decode(List<Character> list, BufferedWriter dest, int key) {
        for(char c : list) {
            decryption(c, key);
            try {
                dest.write(decryption(c, key));
            } catch (IOException e) {
                e.printStackTrace();
                throw new AppException(e.getMessage());
            }
        }
    }
}
