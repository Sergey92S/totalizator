package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.WinLevelDao;
import com.shmouradko.totalizator.entity.WinLevel;
import com.shmouradko.totalizator.viewobject.WinLevelInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 10.01.2017.
 */
public class WinLevelService {
    private WinLevelDao dao;
    public volatile static WinLevelService instance;

    public WinLevelService() {
        dao = WinLevelDao.getInstance();
    }

    public static WinLevelService getInstance() {

        if (instance == null) {
            synchronized (WinLevelService.class) {
                if (instance == null) {
                    instance = new WinLevelService();
                }
            }
        }
        return instance;
    }

    public List<WinLevel> getAllWinLevels(long id){
        return dao.getAllWinLevels(id);
    }

    public List<WinLevelInfo> getAllWinLevelInfo(long id){
        List<WinLevel> winLevelList = getAllWinLevels(id);
        List<WinLevelInfo> winLevelInfoList = new ArrayList<>();
        for (WinLevel winLevel: winLevelList) {
            winLevelInfoList.add(new WinLevelInfo(winLevel.getCoefficient(), winLevel.getBet()));
        }
        return winLevelInfoList;
    }
}
