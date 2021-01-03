package org.example;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class addwordController{
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();
    public static String word = "";
    public static String explain = "";
    @FXML
    private TextField Word;

    @FXML
    private TextField Explain;

    @FXML
    public void getWord(ActionEvent event) {
        word = Word.getText();
        explain = Explain.getText();
        if (word.trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Từ không hợp lệ!");
            alert.showAndWait();
        } else {
            word = word.toLowerCase().trim();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Thêm từ thành công!");
            alert.showAndWait();
        }
    }

    @FXML
    public void getDifinition(ActionEvent event) {
        word = Word.getText();
        explain = Explain.getText();
        if (explain.trim().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Ngĩa không hợp lệ!");
            alert.showAndWait();
        } else {
            explain = explain.toLowerCase().trim();
            dictionaryManagement.addWord();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Thêm nghĩa thành công!");
            alert.showAndWait();
        }
    }
}
