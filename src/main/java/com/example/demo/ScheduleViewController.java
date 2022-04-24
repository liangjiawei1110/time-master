package com.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ScheduleViewController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;


    private MainApp mainApp;
    private ObservableList<ObservableList<EventItem>> eventList;
    @FXML
    private ArrayList<Button> buttonList = new ArrayList<Button>();

    @FXML
    public void showEventList() {
        this.eventList = mainApp.geteventList();
        var it = eventList.iterator();
        int i = 0;
        for (var button : buttonList) {
            if(!it.hasNext()){
                break;
            }
            var list = it.next();
            String text = "";
            for (var e : list) {
                text += e.getTitle() + e.getContent() + "\n";
            }
            button.setText(text);
        }

    }
    @FXML
    private void onButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("schedule_dialog-view.fxml"));
        AnchorPane page  =   loader.load();
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(mainApp.getStage());
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    @FXML
    private void initialize() throws IOException{
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);

    }


    public ScheduleViewController() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
