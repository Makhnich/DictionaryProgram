/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dictionaryprogram;

/**
 *
 * @author home
 */
import java.util.*;

public class DictionaryProgram {
    private static Map<String, List<String>> dictionary = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("Вариант5_Махнич_Григорий_Витальевич");
        initializeDictionary();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВыберите действие:\n1. Добавить слово в словарь\n2. Удалить слово из словаря\n3. Выйти из программы");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addWordToDictionary(scanner);
                    break;
                case 2:
                    removeWordFromDictionary(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите 1, 2 или 3.");
            }

            displayDictionary();
        }

        scanner.close();
    }

    private static void addWordToDictionary(Scanner scanner) {
        System.out.println("Введите английское слово:");
        String word = scanner.nextLine();
        
        List<String> translations = dictionary.get(word);
        if (translations == null) {
            translations = new ArrayList<>();
            dictionary.put(word, translations);
        }

        System.out.println("Введите русский перевод:");
        String translation = scanner.nextLine();
        translations.add(translation);
    }

    private static void removeWordFromDictionary(Scanner scanner) {
        System.out.println("Введите слово для удаления:");
        String word = scanner.nextLine();
        
        dictionary.remove(word);
    }

    private static void displayDictionary() {
        System.out.println("\nСловарь:");
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            List<String> translations = entry.getValue();
            for (int i = 0; i < translations.size(); i++) {
                System.out.print(translations.get(i));
                if (i < translations.size() - 1) {
                    System.out.print("; ");
                }
            }
            System.out.println();
        }
    }

    private static void initializeDictionary() {
        dictionary.put("Abdication", Arrays.asList("отречение", "отказ", "сложение полномочий"));
        dictionary.put("Aperitif", Collections.singletonList("аперитив"));
        dictionary.put("Mead", Arrays.asList("мёд", "луг"));
        dictionary.put("Zizz", Collections.singletonList("жужжание"));
    }
}