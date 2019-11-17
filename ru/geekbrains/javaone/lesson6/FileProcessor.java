package ru.geekbrains.javaone.lesson6;

import java.io.*;
import java.util.Arrays;

public class FileProcessor {

    public File createTextFile(String text, String nameFile) {
        File textFile = new File(nameFile);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(textFile);
            for (int i = 0; i < text.length(); i++) {
                fos.write(text.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла " + nameFile);
            }
        }
        return textFile;
    }

    public String readTextFile(File file) {
        StringBuilder sb = new StringBuilder();
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                int i;
                while ((i = fis.read()) != -1) {
                    sb.append((char) i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return "Файл не найден.";
        }
        return sb.toString();
    }


    public File mergeFiles(File folder, File... files) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbFileName = new StringBuilder();

        for (File file : files) {
            sb.append("STRING FROM FILE ");
            sb.append(file.getName());
            sb.append("\n");
            sb.append(readTextFile(file));
            sb.append("\n");

            sbFileName.append(file.getName());
        }
        return createTextFile(sb.toString(), folder.getAbsolutePath() + File.separator + sbFileName.toString());
    }


    public boolean wordSearchInFile(String searchInText, File file) {
        String content = readTextFile(file);
        return content.contains(searchInText);
    }

    public File[] wordSearchInFolder(String searchInText, File folder) {
        File[] files = folder.listFiles();
        File[] result = new File[files.length];
        int n = 0;
        for (int i = 0; i < files.length; i++) {
            if (wordSearchInFile(searchInText, files[i])) {
                result[n] = files[i];
                n++;
            }
        }
        return Arrays.copyOfRange(result,0, n);
    }
}

