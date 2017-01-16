package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.EventDao;
import com.shmouradko.totalizator.entity.Event;
import com.shmouradko.totalizator.viewobject.EventInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class EventService {
    private EventDao dao;
    private TeamService teamService = TeamService.getInstance();
    public volatile static EventService instance;

    public EventService() {
        dao = EventDao.getInstance();
    }

    public static EventService getInstance() {
        if (instance == null) {
            synchronized (EventService.class) {
                if (instance == null) {
                    instance = new EventService();
                }
            }
        }
        return instance;
    }

    public List<Event> getAllEvents(long id){
        return dao.getAllEvents(id);
    }

    public List<EventInfo> getAllEventInfo(long id){
        List<Event> eventList = getAllEvents(id);
        List<EventInfo> eventInfoList = new ArrayList<>();
        for (Event event: eventList) {
            eventInfoList.add(new EventInfo(teamService.getTeam(event.getId()).getName(), event.isHome()));
        }
        return eventInfoList;
    }
}
