package ru.javarush.kozhevnikova.cryptoalalizer;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OneMainClass {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи \"1\" для шифрования, \"2\" для дешифрования, \"3\" для bruteforce");
        int number = scanner.nextInt();

        System.out.println("Введи путь к файлу либо нажми \"q\" для того что бы использовать файл по умолчанию");
        String scanSource = scanner.next();

        if (scanSource.equals("q")) {
            AnotherConstants.checkDirectory();
            AnotherConstants.checkFile();
            scanSource = AnotherConstants.PATHOFFILE + "text.txt";
        }else {
            File source = new File(scanSource);
            if (!source.exists()) {
                throw new AppException("Исходный файл не найден");
            }
        }

        System.out.println("Введи путь к файлу либо нажми \"q\" для того что бы использовать файл по умолчанию");
        String scanDest = scanner.next();

        if (scanDest.equals("q")) {
            AnotherConstants.checkDirectory();
            AnotherConstants.checkFile(number);
            scanDest = AnotherConstants.PATHOFFILE + "text" + number +".txt";
        } else {
            File dest = new File(scanDest);
            if (!dest.exists()) {
                throw new RuntimeException("Конечный файл не найден");
            }
        }

        Path path = Path.of(scanSource);
        List<String> list = Files.readAllLines(path);
        List<Character> listToChar = new ArrayList<>();

        String str = "";
        for (String s : list) {
            str = str + s;
        }

        for (int i = 0; i < str.length(); i++) {
            listToChar.add(str.charAt(i));
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanDest))) {

            switch (number) {
                case (1):
                    System.out.println("key");
                    int key = scanner.nextInt();
                    AnotherConstants.findKey(key);
                    Encode.encode(listToChar, bufferedWriter, key);
                    break;
                case (2):
                    System.out.println("key");
                    key = scanner.nextInt();
                    AnotherConstants.findKey(key);
                    Decode.decode(listToChar, bufferedWriter, key);
                    break;
                case (3):
                    BruteForce.brute(listToChar, bufferedWriter);
                    break;
            }
        }
    }
}