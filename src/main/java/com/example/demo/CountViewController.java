package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class CountViewController {
    @FXML
    TextField textField;
    @FXML
    DatePicker datePicker;
    MainApp mainApp;

    @FXML
    protected void onOkButtonClick() {
        String text = textField.getText();
        LocalDate nowDate = LocalDate.now();
        LocalDate pickedDate = datePicker.getValue();
        if(!text.isEmpty()){
            Period next = Period.between(nowDate,pickedDate);
            mainApp.getController().countDownLabel.setText("距离"+text+"还有:"
             +next.getYears()+"年" +next.getMonths()+"月"+next.getDays()+"天");
        }
        return;





    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }


}
