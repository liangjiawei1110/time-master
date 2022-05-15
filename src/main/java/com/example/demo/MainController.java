package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.LocalDate;

//主界面控制器类
public class MainController {
    @FXML
    public Label countDownLabel;



    private MainApp mainApp;
    private BorderPane root;
    private Boolean isScheduleView;//当前是否为日程界面正中显示
    private LocalDate onShowDate;//当前显示的日期
    private ScheduleViewController scheduleViewController;

    public void init() throws IOException{
        onScheduleButtonClick();

    }
    public ScheduleViewController getScheduleViewController(){
        return scheduleViewController;
    }
    @FXML
    protected void onScheduleButtonClick() throws IOException {
        //"日程"按钮回调函数,切换到日程界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("schedule-view.fxml"));
        root.setCenter(loader.load());
        scheduleViewController = loader.getController();
        scheduleViewController.setMainApp(mainApp);
        scheduleViewController.showEventList();
        onShowDate = LocalDate.now();
        if(countDownLabel.getText()==""){
            countDownLabel.setText("当前暂无事件");
        }
        isScheduleView = true;
    }

    @FXML
    protected void onListButtonClick() throws IOException {
        //"清单"按钮回调函数,切换到清单界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("list-view.fxml"));
        root.setCenter(loader.load());
        ListViewController controller = loader.getController();
        controller.setMainApp(mainApp);
        controller.init();

        isScheduleView = false;
    }

    @FXML
    protected void onCountdownButtonClick() throws IOException {
        //"倒计时"按钮回调函数,切换到倒计时界面
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("countdown-view.fxml"));
        root.setCenter(loader.load());
        CountViewController countViewController = loader.getController();
        countViewController.setMainApp(mainApp);

        isScheduleView = false;
    }

    @FXML
    protected void onLeftShiftButtonClick() throws IOException {
        if(isScheduleView){
            onShowDate = onShowDate.minusDays(3);
            scheduleViewController.showEventList(onShowDate);

        }
    }


    @FXML
    protected void onRightShiftButtonClick() throws IOException {
        if(isScheduleView){
            onShowDate = onShowDate.plusDays(3);
            scheduleViewController.showEventList(onShowDate);
        }
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
    //刷新并显示日程界面
    public void update(){
        scheduleViewController.showEventList(onShowDate);
    }
    //刷新并显示清单界面
    public void updateToList() throws IOException{
        scheduleViewController.showEventList(onShowDate);
        onListButtonClick();

    }
}