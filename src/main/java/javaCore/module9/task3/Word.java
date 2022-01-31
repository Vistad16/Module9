package javaCore.module9.task3;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Word implements Comparable<Word> {

    private final String string;
    private final int anInt;

    public String getString() {
        return string;
    }


    public int getAnInt() {
        return anInt;
    }


    public Word(Map.Entry<String, AtomicInteger> entry) {
        this.string = entry.getKey();
        this.anInt = entry.getValue().get();
    }


    @Override
    public int compareTo(Word o) {
        return Integer.compare(this.getAnInt(), o.getAnInt());
    }

    @Override
    public String toString() {
        return string + " " + anInt;
    }
}

