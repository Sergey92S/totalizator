package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.entity.Person;
import com.shmouradko.totalizator.service.CompetitionService;
import com.shmouradko.totalizator.service.LoginService;
import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Revotech on 05.01.2017.
 */
public class LoginCommand extends ActionCommand implements ICommand{

    public enum ClientType {
        GUEST, USER, ADMIN
    }

    private static Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());
    private String page;

    @Override
    public String execute(HttpServletRequest request) {
        CompetitionService competitionService = CompetitionService.getInstance();
        request.getSession().setAttribute(RESULT_ATTRIBUTE, competitionService.getAllGames());
        request.getSession().setAttribute(TOTAL_COUNT_ATTRIBUTE, competitionService.getAllGames().size());
        LoginService loginService = LoginService.getInstance();
        Person person = loginService.findPerson(request.getParameter(PERSON_LOGIN_ATTRIBUTE), request.getParameter(PERSON_PASSWORD_ATTRIBUTE));
        if(validation(person)){
            switch (person.getRole()) {
                case 1:
                    request.getSession().setAttribute(PERSON_ATTRIBUTE, person);
                    request.getSession().setAttribute(PERSON_TYPE_ATTRIBUTE,
                            ClientType.USER);
                    request.getSession().setAttribute(PERSON_NAME_ATTRIBUTE,
                            person.getName());
                    request.getSession().setAttribute(PERSON_SURNAME_ATTRIBUTE,
                            person.getSurname());
                    request.getSession().setAttribute(PERSON_BALANCE_ATTRIBUTE,
                            person.getBalance());
                    request.setAttribute(PERSON_LOGIN_ATTRIBUTE,
                            person.getLogin());
                    request.setAttribute(PERSON_PASSWORD_ATTRIBUTE,
                            person.getPassword());
                    if (request.getSession().getAttribute(MATCH_RESULT_ATTRIBUTE) != null){
                        page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH_USER);
                    } else {
                        page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION_USER);
                    }
                    break;
                case 2:
                    request.getSession().setAttribute(PERSON_ATTRIBUTE, person);
                    request.getSession().setAttribute(PERSON_TYPE_ATTRIBUTE,
                            ClientType.ADMIN);
                    request.getSession().setAttribute(PERSON_NAME_ATTRIBUTE,
                            person.getName());
                    request.getSession().setAttribute(PERSON_SURNAME_ATTRIBUTE,
                            person.getSurname());
                    request.getSession().setAttribute(PERSON_BALANCE_ATTRIBUTE,
                            person.getBalance());
                    request.setAttribute(PERSON_LOGIN_ATTRIBUTE,
                            person.getLogin());
                    request.setAttribute(PERSON_PASSWORD_ATTRIBUTE,
                            person.getPassword());
                    page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION_ADMIN);
                    break;
                default:
                    request.getSession().setAttribute(PERSON_ATTRIBUTE,
                            ClientType.GUEST);
                    request.getSession().setAttribute(ERROR_LOGIN,
                            ERROR_LOGIN_MESSAGE);
                    page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION);
            }
        }else {
            request.getSession().setAttribute(PERSON_TYPE_ATTRIBUTE,
                    ClientType.GUEST);
            request.getSession().setAttribute(ERROR_LOGIN,
                    ERROR_LOGIN_MESSAGE);
            page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION);
        }
        LOGGER.log(Level.DEBUG, page);
        return page;
    }

    private static boolean validation(Person person){
        return person != null ? true : false;
    }

}
