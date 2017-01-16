package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.TeamDao;
import com.shmouradko.totalizator.entity.Team;

/**
 * Created by Revotech on 10.01.2017.
 */
public class TeamService {
    private TeamDao dao;
    public volatile static TeamService instance;

    public TeamService() {
        dao = TeamDao.getInstance();
    }

    public static TeamService getInstance() {
        if (instance == null) {
            synchronized (TeamService.class) {
                if (instance == null) {
                    instance = new TeamService();
                }
            }
        }
        return instance;
    }

    public Team getTeam(long id){
        return dao.getTeam(id);
    }
}
