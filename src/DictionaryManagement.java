import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DictionaryManagement {
    static Scanner input = new Scanner(System.in);
    static Dictionary dictionary = new Dictionary();
    static DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();

    public static void insertFromCommandLine() {
        System.out.println("Nhập số lượng từ : ");
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ : ");
            String s = input.nextLine();
            System.out.println("Nhập nghĩa: ");
            String d = input.nextLine();
            Word temp = new Word(s, d);
            dictionary.getListWords().add(temp);
        }
        dictionary.getListWords().sort((o1, o2) -> o1.getWord().compareTo(o2.getWord()));
        System.out.println("Thêm từ thành công !" + "\n");
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

    public static void removeFromCommandLine() {
        System.out.println("Nhập từ bạn muốn xóa: ");
        String message = input.nextLine();
        int index = dictionary.isContain(message);
        if (index >= 0) {
            dictionary.getListWords().remove(index);
        } else {
            System.out.println("Từ bạn muốn xóa không có trong từ điển!" + "\n");
        }
    }

    public static void modifyFromCommandLine() {
        System.out.println("Nhập từ bạn muốn sửa: ");
        String message = input.nextLine();
        int index = dictionary.isContain(message);
        if (index >= 0) {
            System.out.println("Nhập nghĩa bạn muốn sủa: ");
            String word = input.nextLine();
            dictionary.getListWords().get(index).setExplain(word);
        } else {
            System.out.println("Từ này không có trong từ điển" + "\n");
        }
    }

    public static void dictionaryExportToFile() {
        String fileName = "FileExport.txt";
        String line;
        try {
            File newFile = new File(fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < dictionary.getListWords().size(); i++) {
                line = dictionary.getListWords().get(i).getWord() + " " + dictionary.getListWords().get(i).getExplain() + "\n";
                writer.append(line);
            }
            System.out.println("Xuất dữ liệu thành công ra (FileExport.txt) !" + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        System.out.println("Nhập từ bạn muốn tìm : ");
        Scanner in = new Scanner(System.in);
        String explain = "";
        String word = in.nextLine();
        int index = dictionary.isContain(word);
        if (index >= 0) {
            System.out.println("Nghĩa của từ " + "(" + dictionary.getListWords().get(index).getWord() + ") " + "la : " + dictionary.getListWords().get(index).getExplain() + "\n");
        } else {
            dictionaryCommandLine.dictionarySearcher(word);
        }
    }

}
