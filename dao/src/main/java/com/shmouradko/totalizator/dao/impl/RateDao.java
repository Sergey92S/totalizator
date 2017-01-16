package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.entity.Match;
import com.shmouradko.totalizator.entity.WinLevel;
import com.shmouradko.totalizator.viewobject.EventInfo;
import com.shmouradko.totalizator.viewobject.RateInfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revotech on 11.01.2017.
 */
public class RateDao {
    public volatile static RateDao instance;

    private RateDao() {
        super();
    }

    public static RateDao getInstance() {
        if (instance == null) {
            synchronized (RateDao.class) {
                if (instance == null) {
                    instance = new RateDao();
                }
            }
        }
        return instance;
    }

    public List<Long> getAllUserWinLevelId(long id){
        List<Long> idList = new ArrayList<>();
        if(id == 1){
            idList = new ArrayList<>();
            idList.add(new Long(1));
            idList.add(new Long(3));
        }
        return idList;
    }

    public List<RateInfo> getAllUserRates(long id){
        List<RateInfo> rateInfoList = new ArrayList<>();
        List<EventInfo> eventInfoList = new ArrayList<>();
        eventInfoList.add(new EventInfo("Real", false));
        eventInfoList.add(new EventInfo("Barcelona", true));
        rateInfoList.add(new RateInfo(eventInfoList, new Timestamp(System.currentTimeMillis()), 2.5f, WinLevel.BetType.WIN, Match.ResultType.EMPTY, 1000));
        return rateInfoList;
    }

}
