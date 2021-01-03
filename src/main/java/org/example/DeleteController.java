package org.example;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class DeleteController  {
    Dictionary dictionary = new Dictionary();
    @FXML
    private TextField search;

    @FXML
    public void getWord(ActionEvent event) {
        String word = search.getText();
        int index = dictionary.isContain(word);
        if (index >= 0) {
            DictionaryApplication.index.add(index);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Xóa từ thành công!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setContentText("Từ này không có trong từ điển!");
            alert.showAndWait();
        }
    }
}
