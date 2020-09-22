public class Word {
    private String word_target;
    private String word_explain;

    Word() {
        word_target = "";
        word_explain = "";
    }

    Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getWord() {
        return word_target;
    }

    public String getExplain() {
        return word_explain;
    }
}
