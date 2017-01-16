package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.connection.ConnectionPool;
import com.shmouradko.totalizator.connection.ConnectionWrapper;
import com.shmouradko.totalizator.dao.ICompetitionDao;
import com.shmouradko.totalizator.entity.Competition;
import com.shmouradko.totalizator.entity.SportType;
import com.shmouradko.totalizator.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revotech on 13.12.2016.
 */
public final class CompetitionDao implements ICompetitionDao {
    public static CompetitionDao instance;
    private static final ConnectionPool POOL = ConnectionPool.getInstance();

    private static final String SQL_SPORT_TYPE = "SELECT id, name, description FROM sporttype";
    private static final String SQL_COMPETITION = "SELECT name, image, description, href FROM competition WHERE competition.SportType_ID = ?";

    private CompetitionDao() {
        super();
    }

    public static CompetitionDao getInstance() {
        if (instance == null) {
            instance = new CompetitionDao();
        }
        return instance;
    }

    @Override
    public List<SportType> getAllSportTypes() throws DaoException{
        ConnectionWrapper connection = null;
        List<SportType> sportTypeList;
        try {
            connection = POOL.takeConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(SQL_SPORT_TYPE);
            sportTypeList = new ArrayList<>();
            while (res.next()) {
                sportTypeList.add(new SportType(res.getLong(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException | InterruptedException e) {
            throw new DaoException(e);
        } finally {
            try {
                POOL.returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DaoException(e);
            }
        }
        return sportTypeList;
    }

    @Override
    public List<Competition> getAllCompetitions(long id) throws DaoException {

        ConnectionWrapper connection = null;
        List<Competition> competitionList;
        try {
            connection = POOL.takeConnection();
            PreparedStatement st = connection.prepareStatement(SQL_COMPETITION);
            st.setLong(1, id);
            ResultSet res = st.executeQuery();
            competitionList = new ArrayList<>();
            while (res.next()) {
                competitionList.add(new Competition(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            }
        } catch (SQLException | InterruptedException e) {
            throw new DaoException(e);
        } finally {
            try {
                POOL.returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DaoException(e);
            }
        }
        return competitionList;
    }

}
