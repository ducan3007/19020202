package org.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyController  {
    Dictionary dictionary = new Dictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public static int index;
    public static String explain = "";
    @FXML
    private TextField Word;
    @FXML
    private TextField Explain;
    @FXML
    public void getWord(ActionEvent event) {
        String word = Word.getText();
        index = dictionary.isContain(word);
        if (index < 0 ) {
            Explain.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Không tìm thấy từ! ");
            alert.showAndWait();
        }else{
            explain = dictionary.getListWords().get(index).getExplain();
            Explain.setText(explain);
        }
    }

    @FXML
    public void getDefinition(ActionEvent event) {
        explain = Explain.getText();
        if (explain.trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Ngĩa không hợp lệ!");
            alert.showAndWait();
        } else {
            explain = explain.toLowerCase().trim();
            dictionaryManagement.modifyWord();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Thêm nghĩa thành công!");
            alert.showAndWait();
        }
    }
}
