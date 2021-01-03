package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.sun.speech.freetts.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DictionaryApplication implements Initializable {

    ObservableList observableList = FXCollections.observableArrayList();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();
    public static ArrayList<Integer> index = new ArrayList<>();
    public String input = "";
    @FXML
    public ListView<String> Listword;
    @FXML
    public TextField search;
    @FXML
    public TextArea Explain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadListword();
    }

    public void loadListword() {
        dictionaryManagement.insertFromFile();
        for (int i = 0; i < dictionary.getListWords().size(); ++i) {
            observableList.add(dictionary.getListWords().get(i).getWord());
        }
        Listword.getItems().addAll(observableList);
        Listword.setStyle("-fx-font-size: 1.5em ;");
        Listword.getSelectionModel();
    }

    public void ReloadListView() {
        for (int i = 0; i < dictionary.getListWords().size(); ++i) {
            observableList.add(dictionary.getListWords().get(i).getWord());
        }
        Listword.getItems().addAll(observableList);
    }

    public String getExplain(String input) {
        return dictionaryManagement.dictionaryLookup(input);
    }

    @FXML
    public void getInput(javafx.event.ActionEvent event) {
        input = search.getText().trim();
        Explain.setText(getExplain(input));
    }


    @FXML
    public void getWordOnClick(javafx.scene.input.MouseEvent mouseEvent) {
        input = Listword.getSelectionModel().getSelectedItem();
        Explain.setText(getExplain(input));
    }

    @FXML
    public void searchButtionClicked(MouseEvent mouseEvent) {
        input = search.getText();
        Explain.setText(getExplain(input));
    }

    @FXML
    public void getOnKeyTyped(KeyEvent keyEvent) {
        input = search.getText();
        if (input.equals("")) {
            Listword.scrollTo(0);
        }
        input += keyEvent.getCharacter();
        for (int i = 0; i < observableList.size(); ++i) {
            String value = "" + observableList.get(i);
            if (value.startsWith(input)) {
                Listword.getSelectionModel().select(i);
                Listword.scrollTo(i);
                return;
            }
        }
    }

    @FXML
    public void SaveALLChange(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SaveALLChange.fxml"));
        Parent viewAddBox = (Parent) loader.load();
        Scene scene = new Scene(viewAddBox);
        Stage window = new Stage();
        window.setTitle("Save");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void deleteWord(MouseEvent mouseEvent) throws IOException {
        int indexItem = Listword.getSelectionModel().getSelectedIndex();
        if (indexItem >= 0) {
            Listword.getItems().remove(indexItem);
            dictionary.getListWords().remove(indexItem);
            observableList.clear();
            Listword.getItems().clear();
            ReloadListView();
            Listword.getSelectionModel().select(-1);
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("delete.fxml"));
            Parent parent = (Parent) loader.load();
            Scene scene = new Scene(parent);
            Stage window = new Stage();
            window.setTitle("Delete Word");
            window.setScene(scene);
            window.show();
        }
    }

    @FXML
    public void addWord(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addword.fxml"));
        Parent parent = (Parent) loader.load();
        Scene scene = new Scene(parent);
        Stage window = new Stage();
        window.setTitle("Add Word");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void modifyWord(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Modify.fxml"));
        Parent parent = (Parent) loader.load();
        Scene scene = new Scene(parent);
        Stage window = new Stage();
        window.setTitle("Add Word");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void updateList(MouseEvent mouseEvent) {
        Collections.sort(index);
        for (int i = index.size() - 1; i >= 0; --i) {
            int temp = index.get(i);
            dictionary.getListWords().remove(temp);
            Listword.getItems().remove(temp);
        }
        index.clear();
        observableList.clear();
        Listword.getItems().clear();
        ReloadListView();
    }

    @FXML
    public void getTranslate(MouseEvent mouseEvent)  {
        System.setProperty("mbrola.base", "src/mbrola");
        System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(input);
    }
}
