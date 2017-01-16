package com.shmouradko.totalizator.dao;

import com.shmouradko.totalizator.entity.Competition;
import com.shmouradko.totalizator.entity.SportType;
import com.shmouradko.totalizator.exception.DaoException;

import java.util.List;

/**
 * Created by test on 17.01.2017.
 */
public interface ICompetitionDao {

    /**
     * get all sport types
     * @return List of sport types
     * @throws DaoException if SQLException is thrown
     */
    List<SportType> getAllSportTypes() throws DaoException;

    /**
     * get all competitions
     * @param id Sport Type id
     * @return List of competitions
     * @throws DaoException if SQLException is thrown
     */
    List<Competition> getAllCompetitions(long id) throws DaoException;

}
