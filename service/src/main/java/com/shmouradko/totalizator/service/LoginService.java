package com.shmouradko.totalizator.service;

import com.shmouradko.totalizator.dao.impl.LoginDao;
import com.shmouradko.totalizator.entity.Person;
import com.shmouradko.totalizator.exception.DaoException;

/**
 * Created by Revotech on 05.01.2017.
 */
public class LoginService {
    private LoginDao dao;
    public static LoginService instance;

    public LoginService() {
        dao = LoginDao.getInstance();
    }

    public static LoginService getInstance() {

        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public Person findPerson(String login, String password){
        try {
            return dao.findPerson(login, password);
        } catch (DaoException e){
            throw new RuntimeException(e);
        }
    }

}
