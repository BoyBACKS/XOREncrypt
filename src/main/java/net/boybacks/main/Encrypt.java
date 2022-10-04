package net.boybacks.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static net.boybacks.main.Main.*;

public class Encrypt {

    public static void inputToEncrypt() throws InterruptedException {
        File actual = new File("input\\");
        int i = 0;
        for( File f : actual.listFiles()){
            fileList.add(new File(f.getName()));
            System.out.println(f.getName());
            fileInputNameChanger(i);
            i++;
        }
        if (fileList.isEmpty()) {
            System.out.println("[Console Error (Missing Files)] Folder is empty! Put some files to in folder \"input\" to encrypt them \n");
            return;
        }
        i--;

        System.out.println("[Console Log (Encryption Start)] Encryption process is about to begin");
        Thread.sleep(2500);
        encrypt(i);
        System.out.println("[Console Log (Encryption Completed)] Encryption process completed");

        //System.exit(0);
    }

    public static void fileInputNameChanger(int i) {
        String nonsplitedFile = String.valueOf(fileList.get(i));
        String[] splitedFile = nonsplitedFile.split("\\.");
        String finalsplitedFile = splitedFile[1] + "-xOrƎ-" + splitedFile[0] + ".XORe";
        splitedFileList.add(new File(finalsplitedFile));
    }

    public static void encrypt(int i) {
        FileInputStream in = null;
        FileOutputStream out = null;
        for (int a = 0; a <= i; a++) {
            try {
                in = new FileInputStream("input\\" + fileList.get(a));
                out = new FileOutputStream("encrypt\\" + splitedFileList.get(a));
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
            System.out.println("[Console Log (Encrypted files)] File named \"" + fileList.get(a).getName() + "\" has been encrypted. Progress: " + (a + 1) + "/" + (i + 1));
        }
    }
}
