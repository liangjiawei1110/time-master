package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

//主界面控制器类
public class MainController {
    private MainApp mainApp;
    private BorderPane root;

    @FXML
    protected void onScheduleButtonClick() throws IOException {
        //"日程"按钮回调函数,切换到日程界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("schedule-view.fxml"));
        root.setCenter(loader.load());
        ScheduleViewController controller = loader.getController();
        controller.setMainApp(mainApp);
        controller.showEventList();
    }

    @FXML
    protected void onListButtonClick() throws IOException {
        //"清单"按钮回调函数,切换到清单界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("list-view.fxml"));
        root.setCenter(loader.load());
    }

    @FXML
    protected void onCountdownButtonClick() throws IOException {
        //"清单"按钮回调函数,切换到清单界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("countdown-view.fxml"));
        root.setCenter(loader.load());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.root = mainApp.getRootLayout();
    }

}
