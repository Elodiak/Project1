package ru.javarush.kozhevnikova.cryptoalalizer;

import java.io.*;
import java.util.List;


public class BruteForce {

    public static void brute(List<Character> list, BufferedWriter dest) {
        int foundKey = -1;
        int maxCount = 0;
        for (int key = 0; key < Alphabet.ALPHABET.length; key++) {
           int count = 0;
            for (char c : list) {
                if (Encode.encryption(c, key) == ' ') {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                        foundKey = key;
                    }
                }
            }
        }
        for (char c : list) {
            try {
                dest.write(Encode.encryption(c, foundKey));
            } catch (IOException e) {
                e.printStackTrace();
                throw new AppException(e.getMessage());
            }
        }
    }
}