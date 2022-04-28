package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class CreateDialogViewController {
    private Stage dialogStage;
    private EventList eventList;
    private MainApp mainApp;
    @FXML
    private TextField  titleTextField;
    @FXML
    private TextField  contentTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    void onCancelButton() throws IOException{
        dialogStage.close();
    }
    @FXML
    void onCreateButton() throws IOException{
        LocalDate date = datePicker.getValue();
        eventList.addEvents(new EventItem(titleTextField.getText(),contentTextField.getText(),date));
        dialogStage.close();
        mainApp.updateApp();

    }
    @FXML
    void initialize(){
        datePicker.setValue(LocalDate.now());
    }
    void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    void setDialogStage(Stage stage){
        this.dialogStage = stage;
    }
    void setEventList(EventList eventList){
        this.eventList = eventList;
    }


}
