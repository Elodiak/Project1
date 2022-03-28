package ru.javarush.kozhevnikova.cryptoalalizer;

import java.io.*;
import java.util.List;

public class Encode {
    public static char encryption(char c, int key) {

        for (int i = 0; i < Alphabet.ALPHABET.length; i++) {
            if (Alphabet.ALPHABET[i] == c) {
                if (i + key >= Alphabet.ALPHABET.length) {
                    int num2 = Alphabet.ALPHABET.length - i; // к-во цифр от символа до конца массива
                    int num = key - num2; // к-во которое надо будет добавить
                    i = 0;
                    c = Alphabet.ALPHABET[i + num];
                    break;
                } else {
                    c = Alphabet.ALPHABET[i + key];
                    break;
                }
            }
        }
        return c;
    }

    public static void encode(List<Character> list, BufferedWriter dest, int key) {
        for(char c : list) {
            encryption(c, key);
            try {
                dest.write(encryption(c, key));
            } catch (IOException e) {
                e.printStackTrace();
                throw new AppException(e.getMessage());
            }
        }
    }
}