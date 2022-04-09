package com.example.demo;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;

public class EventItem {
    private final StringProperty title;
    private final StringProperty content;
    private final BooleanProperty isDone;
    private final ObjectProperty<LocalDate> startTime;


    public EventItem(String title,String content){
        this.title = new SimpleStringProperty(title);
        this.content = new SimpleStringProperty(content);
        this.isDone = new SimpleBooleanProperty(false);
        this.startTime = new SimpleObjectProperty<LocalDate>(LocalDate.of(2022,8,11));
    }
    public String getTitle(){
        return title.get();
    }
    public  String getContent(){
        return content.get();
    }
    public Boolean isDone(){
        return isDone.get();
    }
    public LocalDate getStartTime(){
        return startTime.get();
    }
    public void setTitle(String title){
        this.title.set(title);
    }
    public void setContent(String content){
        this.content.set(content);
    }
    public void setIsDone(boolean b){
        this.isDone.set(b);
    }
    public void setStartTime(LocalDate startTime){
        this.startTime.set(startTime);
    }


}
