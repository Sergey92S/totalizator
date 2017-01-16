package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.entity.Match;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class MatchDao {
    public volatile static MatchDao instance;

    private MatchDao() {
        super();
    }

    public static MatchDao getInstance() {
        if (instance == null) {
            synchronized (MatchDao.class) {
                if (instance == null) {
                    instance = new MatchDao();
                }
            }
        }
        return instance;
    }

    public Match getMatch(long id){
        return new Match(1, "Real Vs Barcelona", new Timestamp(System.currentTimeMillis()), Match.ResultType.EMPTY);
    }

    public List<Match> getAllMatches(){
        List<Match> matches = new ArrayList<>();
        matches.add(new Match(1, "Real Vs Barcelona", new Timestamp(System.currentTimeMillis()), Match.ResultType.EMPTY));
        return matches;
    }
}
