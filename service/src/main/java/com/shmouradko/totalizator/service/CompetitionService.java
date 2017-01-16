package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.CompetitionDao;
import com.shmouradko.totalizator.entity.Competition;
import com.shmouradko.totalizator.entity.SportType;
import com.shmouradko.totalizator.exception.DaoException;

import java.util.*;

/**
 * Created by Revotech on 13.12.2016.
 */
public final class CompetitionService implements ICompetitionService {
    private CompetitionDao dao;
    public static CompetitionService instance;

    public CompetitionService() {
        dao = CompetitionDao.getInstance();
    }

    public static CompetitionService getInstance() {
        if (instance == null) {
            instance = new CompetitionService();
        }
        return instance;
    }

    @Override
    public Map<SportType, ArrayList<Competition>> getAllGames() {
        Map<SportType, ArrayList<Competition>> games;
        try {
            games = new TreeMap<>();
            List<SportType> sportTypeList = dao.getAllSportTypes();
            for (SportType sportType : sportTypeList) {
                games.put(sportType, (ArrayList<Competition>) dao.getAllCompetitions(sportType.getId()));
            }
        } catch (DaoException e){
            throw new RuntimeException(e);
        }
        return games;
    }

}
