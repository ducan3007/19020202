import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandLine {
    static Dictionary dictionary = new Dictionary();
    static DictionaryManagement dictonaryManagement = new DictionaryManagement();

    public static void showAllWords() {
        System.out.println("No  | English                       | Vietnamese");
        for (int i = 0; i < dictionary.getListWords().size(); i++) {
            System.out.print(i + 1 + "   | ");
            System.out.printf("%-30s", dictionary.getListWords().get(i).getWord());
            System.out.print("| " + dictionary.getListWords().get(i).getExplain() + "\n");
        }
    }

    public static void dictionaryBasic() {
        dictonaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        dictionaryBasic();
    }
}
