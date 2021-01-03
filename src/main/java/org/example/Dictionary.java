package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {
    private static ArrayList<Word> ListWords = new ArrayList<Word>();

    public static int isContain(String temp) {
        Comparator<Word> comp = new Comparator<Word>() {
            public int compare(Word w1, Word w2) {
                return w1.getWord().compareTo(w2.getWord());
            }
        };
        int index = Collections.binarySearch(ListWords, new Word(temp, ""), comp);
        if (index >= 0) return index;
        return -1;
    }

    public static ArrayList<Word> getListWords() {
        return ListWords;
    }
}
