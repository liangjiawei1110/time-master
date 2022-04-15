package com.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Iterator;

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


    private HelloApplication mainApp;
    private ObservableList<EventItem> eventList;
    @FXML
    private ArrayList<Button> buttonList = new ArrayList<Button>();

    @FXML
    public void showEventList() {
        this.eventList = mainApp.geteventList();
        Iterator<EventItem> it = eventList.iterator();
        int i = 0;
        for (Button button : buttonList) {
            EventItem temp = it.next();
            String data = temp.getStartTime().plusDays(i) + "\n" + temp.getTitle() + "\n" + temp.getContent();
            button.setText(data);
            i++;
        }
    }

    @FXML
    private void initialize() {
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

    public void setMainApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
    }

}
