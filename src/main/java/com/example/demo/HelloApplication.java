package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        BorderPane rootLayout = fxmlLoader.load();
        this.primaryStage = stage;
        this.rootLayout = rootLayout;
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("schedule-view.fxml"));
        AnchorPane scheduleView = (AnchorPane) loader.load();
        //adsf
        rootLayout.setCenter(scheduleView);

        MainController controller = fxmlLoader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(rootLayout);
        stage.setTitle("时间管理大师");
        stage.setScene(scene);
        stage.show();
    }
    public HelloApplication(){

    }

    public static void main(String[] args) {
        launch(args);
    }
    public  Stage getStage(){
        return this.primaryStage;
    }
    public  BorderPane getRootLayout(){
        return  this.rootLayout;
    }
}