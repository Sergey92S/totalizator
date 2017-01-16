package com.shmouradko.totalizator.viewobject;

import com.shmouradko.totalizator.entity.Match;
import com.shmouradko.totalizator.entity.WinLevel;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class MatchInfo {
    private long id;
    private String name;
    private Timestamp time;
    private Match.ResultType result;
    private List<EventInfo> eventInfoList;
    private List<WinLevel> winLevelList;

    public MatchInfo(long id, String name, Timestamp time, Match.ResultType result, List<EventInfo> eventInfoList, List<WinLevel> winLevelList){
        this.id = id;
        this.name = name;
        this.time = time;
        this.result = result;
        this.eventInfoList = eventInfoList;
        this.winLevelList = winLevelList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTime() {
        return time;
    }

    public Match.ResultType getResult() {
        return result;
    }

    public List<EventInfo> getEventInfoList() {
        return eventInfoList;
    }

    public List<WinLevel> getWinLevelList() {
        return winLevelList;
    }
}
