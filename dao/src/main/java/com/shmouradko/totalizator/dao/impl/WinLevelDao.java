package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.entity.WinLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class WinLevelDao {
    public volatile static WinLevelDao instance;

    private WinLevelDao() {
        super();
    }

    public static WinLevelDao getInstance() {
        if (instance == null) {
            synchronized (WinLevelDao.class) {
                if (instance == null) {
                    instance = new WinLevelDao();
                }
            }
        }
        return instance;
    }

    public List<WinLevel> getAllWinLevels(long id){
        List<WinLevel> winLevelList = new ArrayList<>();
        winLevelList.add(new WinLevel(1, 4.5f, WinLevel.BetType.DEFEAT));
        winLevelList.add(new WinLevel(2, 2.5f, WinLevel.BetType.WIN));
        winLevelList.add(new WinLevel(3, 1.5f, WinLevel.BetType.DRAW));
        return winLevelList;
    }

}
