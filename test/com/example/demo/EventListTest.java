package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventListTest {
    EventList eventList;
    MainApp mainApp;
    @BeforeEach
    void setUp() throws IOException{
        mainApp = new MainApp();
        eventList = new EventList();
        eventList.setMainApp(mainApp);
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


    }

    @Test
    void getEvents() {
        ArrayList<EventItem> events = new ArrayList<>();
        LocalDate nowDate = LocalDate.now();
        events = eventList.getEvents(nowDate);
        assertEquals("吃饭", events.get(0).getTitle());
        assertEquals("睡觉", events.get(1).getTitle());
        assertEquals("玩游戏", events.get(2).getTitle());
        events = eventList.getEvents(nowDate.plusDays(2));
        assertEquals("起床", events.get(0).getTitle());
        assertEquals("睡觉", events.get(1).getTitle());
        assertEquals("玩游戏", events.get(2).getTitle());
        assertEquals("看番", events.get(3).getTitle());
        events =eventList.getEvents(nowDate.plusDays(3));
        assertEquals("写代码", events.get(0).getTitle());
        assertEquals("睡觉", events.get(1).getTitle());
        assertEquals("起床", events.get(2).getTitle());

    }

    @Test
    void addEvents() throws IOException{
        LocalDate nowDate = LocalDate.now();
        ArrayList<EventItem> events = new ArrayList<>();
        eventList.addEvents(new EventItem("复习英语","",nowDate));
        eventList.addEvents(new EventItem("复习英语","",nowDate.plusDays(4)));
        eventList.addEvents(new EventItem("复习语文","",nowDate.plusDays(4)));
        eventList.addEvents(new EventItem("复习数学","",nowDate.plusDays(4)));
        events = eventList.getEvents(nowDate);
        assertEquals("吃饭", events.get(0).getTitle());
        assertEquals("睡觉", events.get(1).getTitle());
        assertEquals("玩游戏", events.get(2).getTitle());
        assertEquals("复习英语", events.get(5).getTitle());
        events =eventList.getEvents(nowDate.plusDays(4));
        assertEquals("复习英语", events.get(0).getTitle());
        assertEquals("复习语文", events.get(1).getTitle());
        assertEquals("复习数学", events.get(2).getTitle());

    }

    @Test
    void deleteEvent() throws IOException {
        LocalDate nowDate = LocalDate.now();
        ArrayList<EventItem> events = new ArrayList<>();
        eventList.deleteEvent(0,nowDate);
        eventList.deleteEvent(0,nowDate);
        eventList.deleteEvent(0,nowDate);
        eventList.deleteEvent(0,nowDate);
        events = eventList.getEvents(nowDate);
        assertEquals("写代码",events.get(0).getTitle());
    }

    @Test
    void updateEvent() throws IOException{
        ArrayList<EventItem> events = new ArrayList<>();
        LocalDate nowDate = LocalDate.now();
        eventList.updateEvent(0,new EventItem("起床","",nowDate.plusDays(3)));
        eventList.updateEvent(1,new EventItem("写代码","",nowDate.plusDays(3)));
        eventList.updateEvent(2,new EventItem("睡觉","",nowDate.plusDays(3)));
        events =eventList.getEvents(nowDate.plusDays(3));
        assertEquals("起床", events.get(0).getTitle());
        assertEquals("写代码", events.get(1).getTitle());
        assertEquals("睡觉", events.get(2).getTitle());
    }
}