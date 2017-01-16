package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.entity.Person;
import com.shmouradko.totalizator.service.MatchService;
import com.shmouradko.totalizator.service.RateService;
import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by test on 09.01.2017.
 */
public class MatchCommand extends ActionCommand {
    private String page;

    @Override
    public String execute(HttpServletRequest request) {
        MatchService matchService = new MatchService();
        RateService rateService = new RateService();
        request.getSession().setAttribute(MATCH_RESULT_ATTRIBUTE, matchService.getAllMatchInfo());
        page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION);
        if(LoginCommand.ClientType.GUEST.equals(request.getSession().getAttribute(PERSON_TYPE_ATTRIBUTE))){
            page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH);
        }
        if(LoginCommand.ClientType.USER.equals(request.getSession().getAttribute(PERSON_TYPE_ATTRIBUTE))){
            request.getSession().setAttribute(WIN_LEVEL_ID_ATTRIBUTE, rateService.getAllUserWinLevelId(((Person)(request.getSession().getAttribute(PERSON_ATTRIBUTE))).getId()));
            request.getSession().setAttribute(MATCH_ATTRIBUTE, null);
            request.getSession().setAttribute(WIN_LEVEL_ATTRIBUTE, null);
            page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH_USER);
        }
        return page;
    }
}
