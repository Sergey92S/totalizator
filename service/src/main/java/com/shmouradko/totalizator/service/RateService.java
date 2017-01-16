package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.RateDao;
import com.shmouradko.totalizator.viewobject.RateInfo;

import java.util.List;

/**
 * Created by Revotech on 11.01.2017.
 */
public class RateService {
    private RateDao dao;
    public volatile static RateService instance;

    public RateService() {
        dao = RateDao.getInstance();
    }

    public static RateService getInstance() {
        if (instance == null) {
            synchronized (RateService.class) {
                if (instance == null) {
                    instance = new RateService();
                }
            }
        }
        return instance;
    }

    public List<Long> getAllUserWinLevelId(long id){
        return dao.getAllUserWinLevelId(id);
    }

    public List<RateInfo> getAllUserRates(long id){
        return dao.getAllUserRates(id);
    }

}
