package com.example.demo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

//该类在所有更新事件的函数最后刷新应用显示
//相应的,主应用应当有刷新函数
public class EventList {
    private MainApp mainApp;
    private Deque<ArrayList<EventItem>> eventItemArrayList = new LinkedList<>();
    private LocalDate nowDate; //当前时间


    public EventList() {
        nowDate = LocalDate.now();


    }

    //更新时间
    public void update() {

        nowDate = LocalDate.now();
        mainApp.updateApp();
    }

    //获取某一天的所有事件,方便显示
    public ArrayList<EventItem> getEvents(LocalDate someDay) {
        for (var it : eventItemArrayList) {
            if (it.get(0).getStartTime().equals(someDay)) {
                return it;
            }
        }
        //找不到时返回空值
        return null;
    }

    ///添加一个事件在某一天
    public void addEvents(EventItem eventItem) {

        LocalDate someDay = eventItem.getStartTime();
        for (var it : eventItemArrayList) {
            if (it.get(0).getStartTime().equals(someDay) ) {
                it.add(eventItem);
                return;
            }
        }
        ArrayList<EventItem> events = new ArrayList<>();
        events.add(eventItem);
        eventItemArrayList.add(events);
        mainApp.updateApp();
    }


    //删除某一天的某一事件
    public void deleteEvent(int eventIndex, LocalDate someDay) {
        for (var it : eventItemArrayList) {
            if (it.get(0).getStartTime().equals(someDay)) {
                it.remove(eventIndex);
                return;
            }
        }


        mainApp.updateApp();
    }

    //修改某天的某个事件
    public void updateEvent(int eventIndex, EventItem eventItem) {
        LocalDate someDay = eventItem.getStartTime();
        for (var it : eventItemArrayList) {
            if (it.get(0).getStartTime().equals(someDay)) {

                it.add(eventIndex, eventItem);
                it.remove(eventIndex + 1);
                return;
            }
        }


        mainApp.updateApp();
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
