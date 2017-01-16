package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.entity.Team;

/**
 * Created by Revotech on 10.01.2017.
 */
public class TeamDao {
    public volatile static TeamDao instance;

    private TeamDao() {
        super();
    }

    public static TeamDao getInstance() {
        if (instance == null) {
            synchronized (TeamDao.class) {
                if (instance == null) {
                    instance = new TeamDao();
                }
            }
        }
        return instance;
    }

    public Team getTeam(long id){
        if(id == 1) {
            return new Team(1, "Real");
        }else {
            return new Team(2, "Barcelona");
        }

    }
}
