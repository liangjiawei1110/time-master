package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventViewController {
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField contentTextField;
    @FXML
    private Label beginTimeLabel;
    @FXML
    private Label finishTimeLabel;
    @FXML
    private CheckBox checkBox;

    private EventList eventList;
    private Stage dialogStage;

    private MainApp mainApp;
    private EventItem eventItem;
    private int index;

    @FXML
    public void init() throws IOException {
        titleTextField.setText(eventItem.getTitle());
        beginTimeLabel.setText("起始时间: "+eventItem.getStartTime().toString());
        if (eventItem.isDone()) {
            finishTimeLabel.setText("完成时间: "+eventItem.getFinishTime().toString());
            checkBox.setSelected(true);
        }
        contentTextField.setText(eventItem.getContent());

    }
    @FXML
    protected void onDeleteButtonClick() throws IOException {
        eventList.deleteEvent(index, eventItem.getStartTime());
        mainApp.updateApp();
        dialogStage.close();
    }
    @FXML
    protected void onCancelButtonClick() {
        dialogStage.close();
    }
    @FXML
    protected void onSaveButtonClick() throws IOException {
        EventItem e= new EventItem(titleTextField.getText(),contentTextField.getText(),eventItem.getStartTime());
        e.setIsDone(checkBox.isSelected());
        if(e.isDone()){
            e.setFinishTime(LocalDateTime.now());
        }
        eventList.updateEvent(index,e);
        mainApp.updateApp();
        dialogStage.close();
    }


    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setEventItem(EventItem eventItem, int index) {
        this.eventItem = eventItem;
        this.index = index;

    }


}
