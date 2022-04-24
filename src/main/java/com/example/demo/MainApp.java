package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private EventList eventList;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("main-view.fxml"));
        BorderPane rootLayout = fxmlLoader.load();
        this.primaryStage = stage;
        this.rootLayout = rootLayout;

        MainController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        showScheduleView();
        Scene scene = new Scene(rootLayout);
        stage.setTitle("时间管理大师");
        stage.setScene(scene);
        stage.show();
    }

    public MainApp() {

    }

    public EventList getEventList() {
        return this.eventList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showScheduleView() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("schedule-view.fxml"));
        AnchorPane scheduleView = (AnchorPane) loader.load();
        rootLayout.setCenter(scheduleView);
        ScheduleViewController controller = loader.getController();
        controller.setMainApp(this);
        controller.showEventList();
    }

    public Stage getStage() {
        return this.primaryStage;
    }

    public BorderPane getRootLayout() {
        return this.rootLayout;
    }
    //修改数据后的更新函数
    public void updateApp(){

    }
}