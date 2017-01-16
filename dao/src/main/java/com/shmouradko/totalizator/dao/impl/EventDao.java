package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.entity.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class EventDao {
    public volatile static EventDao instance;

    private EventDao() {
        super();
    }

    public static EventDao getInstance() {
        if (instance == null) {
            synchronized (EventDao.class) {
                if (instance == null) {
                    instance = new EventDao();
                }
            }
        }
        return instance;
    }

    public List<Event> getAllEvents(long id){
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, false));
        events.add(new Event(2, true));
        return events;
    }

}
