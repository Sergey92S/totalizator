package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.entity.Competition;
import com.shmouradko.totalizator.entity.SportType;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by test on 17.01.2017.
 */
public interface ICompetitionService {

    /**
     * get all competitions that according to sport types
     * @return map with key - Sport Type, and value - List of competitions
     */
    Map<SportType, ArrayList<Competition>> getAllGames();

}
