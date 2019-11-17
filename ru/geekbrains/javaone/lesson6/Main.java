package ru.geekbrains.javaone.lesson6;
/*
1. Создать 2 текстовых файла, примерно по 50-100 символов
в каждом(особого значения не имеет);

2. Написать программу, «склеивающую» эти файлы, то есть вначале
идет текст из первого файла, потом текст из второго.

3. Написать программу, которая проверяет присутствует ли указанное
пользователем слово (или словосочетание, или предложение) в файле.
(Работаем только с латиницей)

4. ** Написать метод, проверяющий, есть ли указанное слово в файлах папки
*/

import java.io.File;
import java.util.Arrays;

public class Main {
    private static final String textOne = "TXT***1***. Memory was slow to return. At first there was only pain. The pain was total, everywhere, so that there was no room for memory.";
    private static final String textTwo = "TXT***2***. Along with the pain, there were sounds. When the pain covered the shore of his mind, like a high tide.";

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        File folder = new File("test_files");

        if (!folder.exists()) {
            folder.mkdir();
        }

        File file1 = new File(folder, "Test_1.txt");
        File file2 = new File(folder, "Test_2.txt");

        createFile(fileProcessor, file1, textOne);
        createFile(fileProcessor, file2, textTwo);

        System.out.println("Файлы объединены в файл: " +
                fileProcessor.mergeFiles(folder, file1, file2).getName());

        searchInFile(fileProcessor, file1, "there were sounds");
        searchInFile(fileProcessor, file2, "there were sounds");

        searchInFolder(fileProcessor, folder, "Memory");
        searchInFolder(fileProcessor, folder, "not found");
    }

    private static void createFile(FileProcessor fileProcessor, File file, String text) {
        System.out.println("Создан файл: " + fileProcessor.createTextFile(text, file.getAbsolutePath()).getName());
    }

    private static void searchInFile(FileProcessor fileProcessor, File file, String searchText) {
        System.out.println(fileProcessor.wordSearchInFile(searchText, file));
    }

    private static void searchInFolder(FileProcessor fileProcessor, File folder, String searchText) {
        System.out.println("Поиск слова " + searchText
                + Arrays.toString(fileProcessor.wordSearchInFolder(searchText, folder)));
    }
}
