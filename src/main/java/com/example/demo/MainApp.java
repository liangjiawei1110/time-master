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
import java.time.LocalDate;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private EventList eventList;
    private ScheduleViewController scheduleViewController;
    private MainController controller;
    @Override
    public void start(Stage stage) throws IOException {
        eventList = new EventList();
        eventList.setMainApp(this);
        addTestEvents();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("main-view.fxml"));
        BorderPane rootLayout = fxmlLoader.load();
        this.primaryStage = stage;
        this.rootLayout = rootLayout;

        MainController controller = fxmlLoader.getController();
        this.controller = controller;
        controller.setMainApp(this);
        controller.init();
        scheduleViewController = controller.getScheduleViewController();

        Scene scene = new Scene(rootLayout);
        stage.setTitle("时间管理大师");
        stage.setHeight(600);
        stage.setWidth(720);
        stage.setScene(scene);
        stage.show();
    }

    public MainApp() {

    }

    //添加测试数据
    private void addTestEvents() throws IOException{
        LocalDate nowDate = LocalDate.now();
        eventList.addEvents(new EventItem("吃饭", "", nowDate));
        eventList.addEvents(new EventItem("睡觉", "", nowDate));
        eventList.addEvents(new EventItem("玩游戏", "", nowDate));
        eventList.addEvents(new EventItem("写作业", "", nowDate));
        eventList.addEvents(new EventItem("写代码", "", nowDate));
        eventList.addEvents(new EventItem("玩游戏", "", nowDate.plusDays(1)));
        eventList.addEvents(new EventItem("写代码", "", nowDate.plusDays(1)));
        eventList.addEvents(new EventItem("预习", "", nowDate.plusDays(1)));
        eventList.addEvents(new EventItem("起床", "", nowDate.plusDays(2)));
        eventList.addEvents(new EventItem("睡觉", "", nowDate.plusDays(2)));
        eventList.addEvents(new EventItem("玩游戏", "", nowDate.plusDays(2)));
        eventList.addEvents(new EventItem("看番", "", nowDate.plusDays(2)));
        eventList.addEvents(new EventItem("写代码", "", nowDate.plusDays(3)));
        eventList.addEvents(new EventItem("睡觉", "", nowDate.plusDays(3)));
        eventList.addEvents(new EventItem("起床", "", nowDate.plusDays(3)));
        eventList.addEvents(new EventItem("起床", "", nowDate.plusDays(4)));
        eventList.addEvents(new EventItem("睡觉", "", nowDate.plusDays(4)));
        eventList.addEvents(new EventItem("起床", "", nowDate.plusDays(4)));
        eventList.addEvents(new EventItem("睡觉", "", nowDate.plusDays(4)));
    }
    public EventList getEventList() {
        return this.eventList;
    }

    public static void main(String[] args) {
        launch(args);
    }



    public Stage getStage() {
        return this.primaryStage;
    }
    public MainController getController(){return this.controller;}
    public BorderPane getRootLayout() {
        return this.rootLayout;
    }
    //修改数据后的更新函数
    public void updateApp() throws IOException{
        controller.update();

    }
}