package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<EventItem> eventList= FXCollections.observableArrayList();;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
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
    public HelloApplication(){

        eventList.add(new EventItem("第1件事","内容1"));
        eventList.add(new EventItem("第2件事","内容2"));
        eventList.add(new EventItem("第3件事","内容3"));
        eventList.add(new EventItem("第4件事","内容4"));
        eventList.add(new EventItem("第5件事","内容5"));
        eventList.add(new EventItem("第6件事","内容6"));
        eventList.add(new EventItem("第7件事","内容7"));
        eventList.add(new EventItem("第8件事","内容8"));
        eventList.add(new EventItem("第9件事","内容9"));
    }
    public ObservableList<EventItem> geteventList(){
        return this.eventList;
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void showScheduleView() throws IOException{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("schedule-view.fxml"));
        AnchorPane scheduleView = (AnchorPane) loader.load();
        rootLayout.setCenter(scheduleView);
        ScheduleViewController controller= loader.getController();
        controller.setMainApp(this);
        controller.showEventList();
    }

    public  Stage getStage(){
        return this.primaryStage;
    }
    public  BorderPane getRootLayout(){
        return  this.rootLayout;
    }
}