public class DictionaryCommandLine {
    static Dictionary dictionary = new Dictionary();
    static DictonaryManagement dictonaryManagement = new DictonaryManagement();

    public static void showAllWords() {
        System.out.println("No  | English                       | Vietnamese");
        for (int i = 0; i < dictionary.getListWords().size(); i++) {
            System.out.print(i + 1 + "   | ");
            System.out.printf("%-30s", dictionary.getListWords().get(i).getWord());
            System.out.print("| " + dictionary.getListWords().get(i).getExplain() + "\n");
        }
    }

    public static void dictionarySearcher(String word) {
        int caze = 0;
        boolean check = false;
        String temp;
        String result = "";
        for (int i = 0; i < dictionary.getListWords().size(); ++i) {
            temp = dictionary.getListWords().get(i).getWord();
            if (temp.length() >= word.length()) {
                if (temp.substring(0, word.length()).equals(word)) {
                    check = true;
                    result += temp + ", ";
                    caze++;
                    if (caze == 5) break;
                }
            }
        }
        if (check) {
            System.out.println("Có phải bạn muốn tìm: " + result.substring(0, result.length() - 2) + "\n");
        } else {
            System.out.println("Từ này không có trong từ điển! " + "\n");
        }
    }

    public static void dictionaryAdvanced() {
        dictonaryManagement.insertFromFile();
        showAllWords();
        dictonaryManagement.dictionaryLookup();
        dictonaryManagement.removeFromCommandLine();
        dictonaryManagement.modifyFromCommandLine();
    }

    public static void menu() {
        System.out.print("1. Tra từ." + "\n" + "2. Xóa từ. " + "\n" + "3. Thay đổi từ." + "\n" + "4. Hiện thị tất cả các từ. " + "\n" + "5. Xuất dữ liệu ra file." + "\n" + "6. Thêm từ." + "\n" + "0. Thoát." + "\n");
    }
}
