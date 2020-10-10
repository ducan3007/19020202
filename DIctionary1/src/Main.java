import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
    public static DictionaryManagement dictonaryManagement = new DictionaryManagement();
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        dictonaryManagement.insertFromFile();
        dictionaryCommandLine.menu();
        String Case;
        loop:
        while (true) {
            Case = in.nextLine();
            switch (Case) {
                case "1":
                    dictonaryManagement.dictionaryLookup();
                    dictionaryCommandLine.menu();
                    break;
                case "2":
                    dictonaryManagement.removeFromCommandLine();
                    dictionaryCommandLine.menu();
                    break;
                case "3":
                    dictonaryManagement.modifyFromCommandLine();
                    dictionaryCommandLine.menu();
                    break;
                case "4":
                    dictionaryCommandLine.showAllWords();
                    dictionaryCommandLine.menu();
                    break;
                case "5":
                    dictonaryManagement.dictionaryExportToFile();
                    dictionaryCommandLine.menu();
                    break;
                case "6":
                    dictonaryManagement.insertFromCommandLine();
                    dictionaryCommandLine.menu();
                    break;
                case "0":
                    break loop;
                default:
                    break;
            }
        }

    }
}
