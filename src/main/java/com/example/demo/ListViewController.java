package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ListViewController {
    @FXML
    private VBox box1;
    @FXML
    private VBox box2;

    @FXML
    private ScrollPane scrollPane1;
    @FXML
    private ScrollPane scrollPane2;
    @FXML
    private ListView listView1;
    @FXML
    private ListView listView2;


    private MainApp mainApp;
    private EventList eventList;
    private MainController mainController;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.eventList = mainApp.getEventList();
        this.mainController = mainApp.getController();

    }

    public void init() {
        listView1.getItems().clear();
        listView2.getItems().clear();
//        box1.getChildren().clear();
//        box2.getChildren().clear();
        for (var it : eventList.getEventItemArrayList()) {
            for (var e : it) {
                if (e.isDone()) {
                    Button button = new Button(e.getStartTime() + e.getTitle());
                    button.setOnAction(event -> {
                        listView1.getItems().remove(button);
                        e.setIsDone(false);
                        listView2.getItems().add(button);

                    });
                    listView1.getItems().add(button);
                } else {
                    Button button = new Button(e.getStartTime() + e.getTitle());
                    button.setOnAction(event -> {
                        listView2.getItems().remove(button);
                        e.setIsDone(true);
                        listView1.getItems().add(button);
                    });
                    listView2.getItems().add(button);
                }
            }
        }


    }


    @FXML
    protected void onCreateButtonClick() throws IOException {
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
        init();

    }


}
