package net.boybacks.main;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    static File input, encrypted, output, keySaver;

    static Scanner in = new Scanner(System.in);

    static String word = "test";

    public static void main(String[] args) throws InterruptedException, IOException {
        input = new File("input.txt");
        encrypted = new File("encrypted.data");
        output = new File("output.txt");
        keySaver = new File("key.properties");
        if (!input.exists()) {
            input.createNewFile();
            System.out.println("[Console Log( Creating File)] Creating file \"" + input.getName() + "\"");
        }
        if (!encrypted.exists()) {
            encrypted.createNewFile();
            System.out.println("[Console Log (Creating File)] Creating file \"" + encrypted.getName() + "\"");
        }
        if (!output.exists()) {
            output.createNewFile();
            System.out.println("[Console Log (Creating File)] Creating file \"" + output.getName() + "\"");
        }
        if (keySaver.exists() && keySaver.getPath().contains("key")) {
            String keyFileAsker;
            System.out.println("[Console Log (Key Saver File)] Password file exists, do you want to use it? Y - yes | N - no (Default: Y)");
            keyFileAsker = in.nextLine().toUpperCase();
            if (!keyFileAsker.equalsIgnoreCase("Y") && !keyFileAsker.equalsIgnoreCase("N")) {
                keyFileAsker = "Y";
            }
            if (keyFileAsker.equalsIgnoreCase("Y")) {
                loadKeyWord();
            }
            else {
                System.out.println("[Console Log (Encrypt Word)] Enter the key you want to encrypt the file with (Default: \"test\")");
                word = in.nextLine();
                if (word.equals("")) {
                    word = "test";
                }
                System.out.println("[Console Log (Encrypt Word)] The encrypting key is \"" + word + "\"");
                String keyAsker;
                System.out.println("[Console Log (Key Saver)] Do you want to save the encryption key? Y - yes | N - no (Default: Y)");
                keyAsker = in.nextLine().toUpperCase();
                if (!keyAsker.equalsIgnoreCase("Y") && !keyAsker.equalsIgnoreCase("N")) {
                    keyAsker = "Y";
                }
                if (keyAsker.equalsIgnoreCase("Y")) {
                    saveKeyWord(word);
                }
            }
        }
        else {
            System.out.println("[Console Log (Encrypt Word)] Enter the key you want to encrypt the file with (Domyślne \"test\")");
            word = in.nextLine();
            if (word.equals("")) {
                word = "test";
            }
            System.out.println("[Console Log (Encrypt Word)] The encrypting key is \"" + word + "\"");
            String keyAsker;
            System.out.println("[Console Log (Key Saver)] Do you want to save the encryption key? Y - yes | N - no (Default: Y)");
            keyAsker = in.nextLine().toUpperCase();
            if (!keyAsker.equalsIgnoreCase("Y") && !keyAsker.equalsIgnoreCase("N")) {
                keyAsker = "Y";
            }
            if (keyAsker.equalsIgnoreCase("Y")) {
                saveKeyWord(word);
            }
        }
        Thread.sleep(1500);
        int i = 0;
        System.out.println("[Console Log (Encrypting Method)] Enter 0 - to encrypt, 1 - to decrypt");
        i = in.nextByte();
        if (i == 0) {
            fileChecker(input);
            System.out.println("[Console Log (Encrypting File)] File encryption. This may take a while");
            encryptFile();
            System.out.println("[Console Log (Encrypting File)] The file has been encrypted \"" +  encrypted.getName() + "\"");
            Thread.sleep(1500);
            System.exit(0);
        }
        else if (i == 1) {
            fileChecker(encrypted);
            System.out.println("[Console Log (Encrypting File)] File decryption. This may take a while");
            decryptFile();
            System.out.println("[Console Log (Decrytping File)] The file has been decrypted \"" +  output.getName() + "\"");
            Thread.sleep(1500);
            System.exit(0);
        }
        else {
            System.out.printf("[Console Error (Wrong Method)] Wrong encryption method, exiting the program \n");
            Thread.sleep(1500);
            System.exit(0);
        }
    }

    public static void encryptFile(){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(input);
            out = new FileOutputStream(encrypted);
            int data = 0;
            while ((data=in.read())!=-1){
                out.write(data^word.length());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void decryptFile(){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(encrypted);
            out = new FileOutputStream(output);
            int data = 0;
            while ((data=in.read())!=-1){
                out.write(data^word.length());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileChecker(File file) {
        if (file.length() == 0) {
            System.out.printf("[Console Error (Checking File)] The file is empty. Complete it with data");
            System.exit(0);
        }
    }

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
        System.out.println("[Console Log (Key Saver)] You have successfully saved the key to a file \"key.properties\"");
    }
}