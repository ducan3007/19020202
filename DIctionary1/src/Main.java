import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
    public static DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        dictionaryManagement.insertFromFile();
        dictionaryCommandLine.menu();
        String Case;
        loop:
        while (true) {
            Case = in.nextLine();
            switch (Case) {
                case "1":
                    dictionaryManagement.dictionaryLookup();
                    dictionaryCommandLine.menu();
                    break;
                case "2":
                    dictionaryManagement.removeFromCommandLine();
                    dictionaryCommandLine.menu();
                    break;
                case "3":
                    dictionaryManagement.modifyFromCommandLine();
                    dictionaryCommandLine.menu();
                    break;
                case "4":
                    dictionaryCommandLine.showAllWords();
                    dictionaryCommandLine.menu();
                    break;
                case "5":
                    dictionaryManagement.dictionaryExportToFile();
                    dictionaryCommandLine.menu();
                    break;
                case "6":
                    dictionaryManagement.insertFromCommandLine();
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
