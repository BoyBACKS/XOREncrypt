package net.boybacks.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    static File input, encrypted, output, keySaver;

    static File folderInput,folderOutput,folderEncrypt;

    public static List<File> fileList = new ArrayList<>();
    public static List<File> splitedFileList = new ArrayList<>();


    static Scanner in = new Scanner(System.in);

    public static String word = "test";

    public static void main(String[] args) throws InterruptedException, IOException {

        while (true) {
            keySaver = new File("key.properties");

            folderCreator();

            if (keySaver.exists() && keySaver.getPath().contains("key")) {
                String keyFileAsker;
                System.out.println("[Console Log (Key Saver File)] Password file exists, do you want to use it? Y - yes | N - no (Default: Y)");
                keyFileAsker = in.next().toUpperCase();
                if (!keyFileAsker.equalsIgnoreCase("Y") && !keyFileAsker.equalsIgnoreCase("N")) {
                    keyFileAsker = "Y";
                }
                if (keyFileAsker.equalsIgnoreCase("Y")) {
                    loadKeyWord();
                }
                else {
                    System.out.println("[Console Log (Encrypt Word)] Enter the key you want to encrypt the file with");
                    word = in.next();
                    if (word.equals("")) {
                        word = "test";
                    }
                    System.out.println("[Console Log (Encrypt Word)] The encrypting key is \"" + word + "\"");
                    String keyAsker;
                    System.out.println("[Console Log (Key Saver)] Do you want to save the encryption key? Y - yes | N - no (Default: Y)");
                    keyAsker = in.next().toUpperCase();
                    if (!keyAsker.equalsIgnoreCase("Y") && !keyAsker.equalsIgnoreCase("N")) {
                        keyAsker = "Y";
                    }
                    if (keyAsker.equalsIgnoreCase("Y")) {
                        saveKeyWord(word);
                    }
                }
            }
            else {
                System.out.println("[Console Log (Encrypt Word)] Enter the key you want to encrypt the file with");
                word = in.next();
                if (word.equals("")) {
                    word = "test";
                }
                System.out.println("[Console Log (Encrypt Word)] The encrypting key is \"" + word + "\"");
                String keyAsker;
                System.out.println("[Console Log (Key Saver)] Do you want to save the encryption key? Y - yes | N - no (Default: Y)");
                keyAsker = in.next().toUpperCase();
                if (!keyAsker.equalsIgnoreCase("Y") && !keyAsker.equalsIgnoreCase("N")) {
                    keyAsker = "Y";
                }
                if (keyAsker.equalsIgnoreCase("Y")) {
                    saveKeyWord(word);
                }
            }
            Thread.sleep(500);
            String i;
            System.out.println("[Console Log (Encrypting Method)] Enter \"E\" - to encrypt, \"D\" - to decrypt or other to exit program");
            i = in.next();
            if (i.equalsIgnoreCase("e")) {
                Encrypt.inputToEncrypt();
                //System.exit(0);
            }
            else if (i.equalsIgnoreCase("d")) {
                Decrypt.encryptToOutput();
                //System.exit(0);
            }
            else {
                System.out.printf("[Console Log (Shutdowning program)] Exiting the program\n");
                Thread.sleep(1500);
                System.exit(0);
            }

            Thread.sleep(1000);
            fileList.clear();
            splitedFileList.clear();
        }
    }

    public static void folderCreator() {
        folderInput = new File("input\\");
        folderOutput = new File("output\\");
        folderEncrypt = new File("encrypt\\");
        if (!folderInput.exists()) {
            folderInput.mkdir();
            System.out.println("[Console Log (Creating Folder)] Creating file \"" + folderInput.getName() + "\"");
        }
        if (!folderOutput.exists()) {
            folderOutput.mkdir();
            System.out.println("[Console Log (Creating Folder)] Creating file \"" + folderOutput.getName() + "\"");
        }
        if (!folderEncrypt.exists()) {
            folderEncrypt.mkdir();
            System.out.println("[Console Log (Creating Folder)] Creating file \"" + folderEncrypt.getName() + "\"");
        }
    }

//    public static void fileCreator() throws IOException {
//        input = new File("input.jpg");
//        encrypted = new File("encrypted.data");
//        output = new File("output.png");
//        if (!input.exists()) {
//            input.createNewFile();
//            System.out.println("[Console Log (Creating File)] Creating file \"" + input.getName() + "\"");
//        }
//        if (!encrypted.exists()) {
//            encrypted.createNewFile();
//            System.out.println("[Console Log (Creating File)] Creating file \"" + encrypted.getName() + "\"");
//        }
//        if (!output.exists()) {
//            output.createNewFile();
//            System.out.println("[Console Log (Creating File)] Creating file \"" + output.getName() + "\"");
//        }
//    }
//
//    public static void fileChecker(File file) {
//        if (file.length() == 0) {
//            System.out.printf("[Console Error (Checking File)] The file is empty. Complete it with data");
//            System.exit(0);
//        }
//    }

    static Properties properties = new Properties();

    public static void saveKeyWord(String word) {
        try {
            properties.setProperty("key", word);
            properties.store(new FileOutputStream("key.properties"), null);
            System.out.println("[Console Log (Key Saver)] You have successfully saved the key to a file \"key.properties\"");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadKeyWord() throws IOException {
        FileInputStream inputStream = new FileInputStream(keySaver);
        properties.load(inputStream);
        word = String.valueOf(properties.get("key"));
        System.out.println("[Console Log (Key Saver)] You have successfully load the key from \"key.properties\" file");
    }
}