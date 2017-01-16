package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by test on 23.11.2016.
 */
public abstract class ActionCommand implements ICommand {
    static PageManager pageManager;

    // REQUEST ATTRIBUTES
    static final String RATE_ATTRIBUTE = "rateResult";
    static final String MATCH_ATTRIBUTE = "match";
    static final String WIN_LEVEL_ATTRIBUTE = "winLevel";
    static final String WIN_LEVEL_ID_ATTRIBUTE = "winLevelUser";
    static final String TOTAL_COUNT_ATTRIBUTE = "totalCount";
    static final String RESULT_ATTRIBUTE = "result";
    static final String MATCH_RESULT_ATTRIBUTE = "matchResult";
    static final String PERSON_ATTRIBUTE = "person";
    static final String PERSON_TYPE_ATTRIBUTE = "personType";
    static final String PERSON_LOGIN_ATTRIBUTE = "login";
    static final String PERSON_PASSWORD_ATTRIBUTE = "password";
    static final String PERSON_NAME_ATTRIBUTE = "name";
    static final String PERSON_SURNAME_ATTRIBUTE = "surname";
    static final String PERSON_BALANCE_ATTRIBUTE = "balance";

    // ATTRIBUTE DEFINITION
    static final String ERROR_LOGIN_MESSAGE = "There is no such person!!!";

    // REQUEST ERRORS
    static final String ERROR_LOGIN = "errorLoginMessage";

    protected ActionCommand(){
        pageManager = PageManager.getInstance();
    }

}
