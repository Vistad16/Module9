package javaCore.module9.task3;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SameWords {

    public static Map<String, AtomicInteger> getWordsCount(String[] words) {
        Map<String, AtomicInteger> atomicIntegerMap = new HashMap<>();
        for (String s : words) {
            atomicIntegerMap.computeIfAbsent(s, key -> new AtomicInteger(0))
                    .getAndIncrement();


        }
        return atomicIntegerMap;
    }

    //old version
    /*public static void checkWords(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words); //add words
        String[] differentWords = set.toArray(String[]::new); //convert to array



        //revers output
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


        count words
        int count = 0;
        for (int i = 0; i < differentWords.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (!differentWords[i].equals(words[j])) {
                    continue;
                } else {
                    count++;
                }
            }
            //add result
            result.put(differentWords[i], count);
            count = 0;
        }
    }*/
}


