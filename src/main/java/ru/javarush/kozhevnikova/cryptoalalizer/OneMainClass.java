package ru.javarush.kozhevnikova.cryptoalalizer;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class OneMainClass {

    public static final String TXT = System.getProperty("user.dir")+File.separator+"text"+File.separator;


    public static void main(String[] args) throws IOException {

        System.out.println(TXT);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи \"1\" для шифрования, \"2\" для дешифрования, \"3\" для bruteforce");
        int number = scanner.nextInt();

        System.out.println("Введи путь к файлу:");

        String scanSource = scanner.next();

        //String scanSource = "/Users/nasty/Desktop/text.txt";


        if (scanSource.equals("exit")) {
            File source = new File(scanSource);
            if (!source.exists()) {
                throw new AppException("File not found");
            }
        }

        System.out.println("Введи путь к файлу либо нажми \"exit\" для того что бы использовать файл по умолчанию");

            String scanDest = scanner.next();

            if(scanDest.equals("exit")) {
                scanDest = TXT + "text.txt";
                Files.createDirectory(Path.of(TXT));
                Files.createFile(Path.of(scanDest));
            }

        System.out.println(scanDest);

        try (FileReader source = new FileReader(scanSource);
             FileWriter destination = new FileWriter(scanDest)) {

//        try (FileReader source = new FileReader("/Users/nasty/Desktop/Project/Project1/src/main/java/ru/javarush/kozhevnikova/cryptoalalizer/TextOne.txt");
//             FileWriter destination = new FileWriter("/Users/nasty/Desktop/text3.txt")) {

            System.out.println("key");
            int key = scanner.nextInt(); //от 0 до длины алфавита

            if (key > Alphabet.alphabet.length) {
                key = key % Alphabet.alphabet.length;
            }

            switch (number) {
                case (1):
                    Encode.encode(source, destination, key);
                    break;
                case (2):
                    Decode.decode(source, destination, key);
                    break;
                case (3):
                    break;
            }

        }
    }
}
