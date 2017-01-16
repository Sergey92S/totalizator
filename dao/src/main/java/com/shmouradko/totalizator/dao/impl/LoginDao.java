package com.shmouradko.totalizator.dao.impl;

import com.shmouradko.totalizator.connection.ConnectionPool;
import com.shmouradko.totalizator.connection.ConnectionWrapper;
import com.shmouradko.totalizator.entity.Person;
import com.shmouradko.totalizator.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Revotech on 05.01.2017.
 */
public final class LoginDao {
    public static LoginDao instance;
    private static final String SQL_PERSON = "SELECT id, name, surname, login, password, country, secret_question, secret_answer, email, age, role, balance FROM person WHERE (person.login = ?) AND (person.password = ?)";
    private static final ConnectionPool POOL = ConnectionPool.getInstance();

    private LoginDao() {
        super();
    }

    public static LoginDao getInstance() {
        if (instance == null) {
            instance = new LoginDao();
        }
        return instance;
    }

    public Person findPerson(String login, String password) throws DaoException{

        ConnectionWrapper connection = null;
        Person person = null;
        try {
            connection = POOL.takeConnection();
            PreparedStatement st = connection.prepareStatement(SQL_PERSON);
            st.setString(1, login);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            if (res.next()) {
                person = new Person(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getInt(10), res.getInt(11), res.getInt(12));
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
        return person;
    }
}
