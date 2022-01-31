package javaCore.module9.task3;

import java.io.File;

public class WordFrequencyTest {
    public static void main(String[] args) {
        WordFrequency wordFrequency = new WordFrequency();
        wordFrequency.frequency(new File("words.txt"));
    }
}
