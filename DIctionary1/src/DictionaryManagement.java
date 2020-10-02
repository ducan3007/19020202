import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {
    static Scanner input = new Scanner(System.in);
    static Dictionary dictionary = new Dictionary();
    static DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();

    public static void insertFromCommandLine() {
        System.out.println("Nhap so luong tu : ");
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap word_target: ");
            String s = input.nextLine();
            System.out.println("Nhap word_explain: ");
            String d = input.nextLine();
            Word temp = new Word(s, d);
            dictionary.getListWords().add(temp);
        }
        dictionary.getListWords().sort((o1, o2) -> o1.getWord().compareTo(o2.getWord()));
    }
    public static void insertFromFile() {
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("Dictionary1/src/dictionaries.txt")));
            while (in.hasNext()) {
                String temp = in.nextLine().replaceAll("\\s+", " ");
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == ' ') {
                        Word w = new Word(temp.substring(0, i), temp.substring(i + 1, temp.length()));
                        dictionary.getListWords().add(w);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
        }
    }
    public static void dictionaryLookup() {
        System.out.println("Nhap tu ban muon tra: ");
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int index = dictionary.isContain(word);
        if (index >= 0) {
            System.out.println("Nghĩa của từ " + "(" + dictionary.getListWords().get(index).getWord() + ") " + "la : " + dictionary.getListWords().get(index).getExplain());
        } else {
            System.out.println("Từ này không có trong từ điển!");
        }
    }
}
