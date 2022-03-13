package ru.javarush.kozhevnikova.cryptoalalizer;


import java.io.*;
import java.util.Scanner;

public class OneMainClass {


    public static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            ' ', '.', ',', '!', '?'};

    public static void encryption(char c, int key) {

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                if (i + key >= alphabet.length) {
                    int num2 = alphabet.length - i; // к-во цифр от символа до конца массива
                    int num = key - num2; // к-во которое надо будет добавить
                    i = 0;
                    System.out.print(alphabet[i + num]);
                    break;
                } else {
                    System.out.print(alphabet[i + key]);
                    break;
                }

            }
        }

    }


//    public static void decryption(char c, int key) {
//
//    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //String scanSource = scanner.nextLine();
        //String scanDestination = scanner.nextLine();
        //System.out.println(alphabet.length);

        try (FileReader source = new FileReader("/Users/nasty/Desktop/text.txt");
             FileWriter destination = new FileWriter("/Users/nasty/Desktop/somethingtext.txt")) {

            int key = scanner.nextInt();

            char[] buffer = new char[65536];

            while (source.ready()) {
                int real = source.read(buffer);
                for (char c : buffer) {
                    encryption(c, key);

                }

                destination.write(buffer, 0, real);
            }


        }
    }
}
