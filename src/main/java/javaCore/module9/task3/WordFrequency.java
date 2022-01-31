package javaCore.module9.task3;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WordFrequency {

    public void frequency(File file) {
        StringBuilder sb = new StringBuilder();

        try (FileReader input = new FileReader(file)) {
            Scanner scanner = new Scanner(input);

            //concat all words in one place
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine().toLowerCase()).append(" ");
            }

            String[] splitWords = sb.toString().split(" ");//split words to array

            Map<String, AtomicInteger> map = SameWords.getWordsCount(splitWords);

            List<Word> wordList = new ArrayList<>();
            for (Map.Entry<String, AtomicInteger> entry : map.entrySet()) {
                wordList.add(new Word(entry));
            }

            //revers
            wordList.sort(Word::compareTo);
            Collections.reverse(wordList);
            for (Word f : wordList) {
                System.out.println(f);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
