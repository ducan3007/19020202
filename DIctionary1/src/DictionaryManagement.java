import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement {
    static Scanner input = new Scanner(System.in);
    static Dictionary dictionary = new Dictionary();

    public static void insertFromCommandline() {
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
}
