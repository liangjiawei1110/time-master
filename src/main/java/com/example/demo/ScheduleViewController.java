package com.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleViewController {

    private MainApp mainApp;
    private EventList eventList;
    private int clickIndex;//选定的事件所在按钮的索引
    private LocalDate clickDate;//选定的事件的时间
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;
    @FXML
    private VBox vBox3;

    @FXML
    ArrayList<Button> buttonArrayList1 = new ArrayList<>();
    @FXML
    ArrayList<Button> buttonArrayList2 = new ArrayList<>();
    @FXML
    ArrayList<Button> buttonArrayList3 = new ArrayList<>();

    public ArrayList<Button> getButtonArrayList1(){
        return buttonArrayList1;
    }public ArrayList<Button> getButtonArrayList2(){
        return buttonArrayList2;
    }public ArrayList<Button> getButtonArrayList3(){
        return buttonArrayList3;
    }


    public void showEventList(LocalDate someDay) {
        LocalDate nowDate = someDay;
        update(nowDate);
        label1.setText(nowDate.toString());
        label2.setText(nowDate.plusDays(1).toString());
        label3.setText(nowDate.plusDays(2).toString());
        vBox1.getChildren().addAll(buttonArrayList1);
        vBox2.getChildren().addAll(buttonArrayList2);
        vBox3.getChildren().addAll(buttonArrayList3);

    }

    public void update(LocalDate someDay) {
        LocalDate nowDate = someDay;
        vBox1.getChildren().removeAll(buttonArrayList1);
        vBox2.getChildren().removeAll(buttonArrayList2);
        vBox3.getChildren().removeAll(buttonArrayList3);
        buttonArrayList1.clear();
        buttonArrayList2.clear();
        buttonArrayList3.clear();
        if (!eventList.getEvents(nowDate).isEmpty()) {
            int index = 0;
            for (var e : eventList.getEvents(nowDate)) {
                Button button = new Button();
                if(e.isDone()){
                    button.setText("已完成: "+e.getTitle());
                }else{
                    button.setText("未完成: "+e.getTitle());
                }
                button.setId(index + "");
                index++;
                button.setOnAction(event -> {
                    clickIndex = Integer.parseInt(button.getId());
                    clickDate = e.getStartTime();
                    try{
                        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("event-view.fxml"));
                        Stage dialogStage = new Stage();
                        dialogStage.initModality(Modality.WINDOW_MODAL);
                        dialogStage.initOwner(mainApp.getStage());
                        Scene scene = new Scene(loader.load());
                        EventViewController controller =loader.getController();
                        controller.setMainApp(mainApp);
                        controller.setDialogStage(dialogStage);
                        controller.setEventList(eventList);
                        controller.setEventItem(e,clickIndex);
                        controller.init();
                        dialogStage.setScene(scene);
                        dialogStage.showAndWait();
                    }catch (IOException exception){
                        exception.printStackTrace();

                    }
                });
                buttonArrayList1.add(button);
            }
        }
        if (!eventList.getEvents(nowDate.plusDays(1)).isEmpty()) {
            int index = 0;
            for (var e : eventList.getEvents(nowDate.plusDays(1))) {
                Button button = new Button();
                if(e.isDone()){
                    button.setText("已完成: "+e.getTitle());
                }else{
                    button.setText("未完成: "+e.getTitle());
                }
                button.setId(index + "");
                index++;
                button.setOnAction(event -> {
                    clickIndex = Integer.parseInt(button.getId());
                    clickDate = e.getStartTime();
                    try{
                        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("event-view.fxml"));
                        Stage dialogStage = new Stage();
                        dialogStage.initModality(Modality.WINDOW_MODAL);
                        dialogStage.initOwner(mainApp.getStage());
                        Scene scene = new Scene(loader.load());
                        EventViewController controller =loader.getController();
                        controller.setMainApp(mainApp);
                        controller.setDialogStage(dialogStage);
                        controller.setEventList(eventList);
                        controller.setEventItem(e,clickIndex);
                        controller.init();
                        dialogStage.setScene(scene);
                        dialogStage.showAndWait();
                    }catch (IOException exception){
                        exception.printStackTrace();

                    }
                });
                buttonArrayList2.add(button);
            }
        }
        if (!eventList.getEvents(nowDate.plusDays(2)).isEmpty()) {
            int index = 0;
            for (var e : eventList.getEvents(nowDate.plusDays(2))) {
                Button button = new Button();
                if(e.isDone()){
                    button.setText("已完成: "+e.getTitle());
                }else{
                    button.setText("未完成: "+e.getTitle());
                }
                button.setId(index + "");
                index++;
                button.setOnAction(event -> {
                    clickIndex = Integer.parseInt(button.getId());
                    clickDate = e.getStartTime();
                    try{
                        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("event-view.fxml"));
                        Stage dialogStage = new Stage();
                        dialogStage.initModality(Modality.WINDOW_MODAL);
                        dialogStage.initOwner(mainApp.getStage());
                        Scene scene = new Scene(loader.load());
                        EventViewController controller =loader.getController();
                        controller.setMainApp(mainApp);
                        controller.setDialogStage(dialogStage);
                        controller.setEventList(eventList);
                        controller.setEventItem(e,clickIndex);
                        controller.init();
                        dialogStage.setScene(scene);
                        dialogStage.showAndWait();
                    }catch (IOException exception){
                        exception.printStackTrace();

                    }
                });
                buttonArrayList3.add(button);
            }
        }


    }

    @FXML
    public void showEventList() {
        showEventList(LocalDate.now());


    }

    public void update() {
        update(LocalDate.now());
    }

    @FXML
    private void onButtonClick() {



    }
    @FXML
    protected void  onCreateButtonClick() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("create-dialog-view.fxml"));
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(mainApp.getStage());
        Scene scene = new Scene(loader.load());
        CreateDialogViewController controller = loader.getController();
        controller.setMainApp(mainApp);
        controller.setDialogStage(dialogStage);
        controller.setEventList(eventList);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    @FXML
    private void initialize() throws IOException {


    }


    public ScheduleViewController() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.eventList = mainApp.getEventList();
    }

    public EventList getEventList() {
        return this.eventList;
    }
}
