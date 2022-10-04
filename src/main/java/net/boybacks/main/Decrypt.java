package net.boybacks.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static net.boybacks.main.Main.*;

public class Decrypt {

    public static void encryptToOutput() throws InterruptedException {
        File actual = new File("encrypt\\");
        int i = 0;
        for( File f : actual.listFiles()){
            fileList.add(new File(f.getName()));
            System.out.println(f.getName());
            fileEncryptNameChanger(i);
            i++;
        }
        if (fileList.isEmpty()) {
            System.out.println("[Console Error (Missing Files)] Folder is empty! Put some files to in folder \"encrypt\" to decrypt them \n");
            return;
        }
        i--;

        System.out.println("[Console Log (Decryption Start)] Decryption process is about to begin");
        Thread.sleep(1000);
        decrypt(i);
        System.out.println("[Console Log (Decryption Completed)] Decryption process completed");
    }

    public static void fileEncryptNameChanger(int i) {
        String nonsplitedFile = String.valueOf(fileList.get(i));
        String[] splitedFile = nonsplitedFile.split("\\.");
        String[] splitedFile1 = splitedFile[0].split("(-xOrƎ-)");
        String finalsplitedFile = splitedFile1[1] + "." + splitedFile1[0];
        splitedFileList.add(new File(finalsplitedFile));
    }

    public static void decrypt(int i) {
        FileInputStream in = null;
        FileOutputStream out = null;
        for (int a = 0; a <= i; a++) {
            try {
                in = new FileInputStream("encrypt\\" + fileList.get(a));
                out = new FileOutputStream("output\\" + splitedFileList.get(a));
                int data = 0;
                while ((data = in.read()) != -1) {
                    out.write(data ^ Main.word.length());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("[Console Log (Decrypted files)] File named \"" + fileList.get(a).getName() + "\" has been decrypted. Progress: " + (a + 1) + "/" + (i + 1));
        }
    }

}
