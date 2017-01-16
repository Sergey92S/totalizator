package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.MatchDao;
import com.shmouradko.totalizator.entity.Match;
import com.shmouradko.totalizator.viewobject.MatchInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revotech on 09.01.2017.
 */
public class MatchService {
    private MatchDao dao;
    private EventService eventService = EventService.getInstance();
    private WinLevelService winLevelService = WinLevelService.getInstance();
    public volatile static MatchService instance;

    public MatchService() {
        dao = MatchDao.getInstance();
    }

    public static MatchService getInstance() {
        if (instance == null) {
            synchronized (MatchService.class) {
                if (instance == null) {
                    instance = new MatchService();
                }
            }
        }
        return instance;
    }

    public Match getMatch(long id){
        return dao.getMatch(id);
    }

    public List<Match> getAllMatches(){
        return dao.getAllMatches();
    }

    public List<MatchInfo> getAllMatchInfo() {
        List<MatchInfo> matchInfoList = new ArrayList<>();
        List<Match> matches;
        matches = getAllMatches();
        for(Match match: matches) {
            matchInfoList.add(new MatchInfo(match.getId(), match.getName(), match.getTime(), match.getResult(), eventService.getAllEventInfo(match.getId()), winLevelService.getAllWinLevels(match.getId())));
        }
        return matchInfoList;
    }

    public MatchInfo getMatchInfo(long id){
        Match match = getMatch(id);
        MatchInfo matchInfo = new MatchInfo(match.getId(), match.getName(), match.getTime(), match.getResult(), eventService.getAllEventInfo(id), winLevelService.getAllWinLevels(id));
        return matchInfo;
    }

}
