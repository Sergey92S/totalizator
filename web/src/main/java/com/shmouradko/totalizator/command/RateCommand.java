package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.entity.Person;
import com.shmouradko.totalizator.service.MatchService;
import com.shmouradko.totalizator.service.RateService;
import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Revotech on 11.01.2017.
 */
public class RateCommand extends ActionCommand {
    private String page;

    @Override
    public String execute(HttpServletRequest request, List<FileItem> multiParts) {
        RateService rateService = new RateService();
        MatchService matchService = new MatchService();
//        request.getSession().setAttribute(MATCH_RESULT_ATTRIBUTE, matchService.getAllMatchInfo());
//        page = pageManager.getProperty(PageManager.PATH_PAGE_DEPOSIT);
//        if(LoginCommand.ClientType.GUEST.equals(request.getSession().getAttribute(PERSON_TYPE_ATTRIBUTE))){
//            page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH);
//        }
//        if(LoginCommand.ClientType.USER.equals(request.getSession().getAttribute(PERSON_TYPE_ATTRIBUTE))){
//            request.getSession().setAttribute(RATE_ATTRIBUTE, rateService.getAllUserRates(((Person)(request.getSession().getAttribute(PERSON_ATTRIBUTE))).getId()));
//            page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH_USER);
//        }
        request.setAttribute(MATCH_ATTRIBUTE, matchService.getMatchInfo(Long.parseLong(request.getParameter(MATCH_ATTRIBUTE))));
        request.setAttribute(WIN_LEVEL_ATTRIBUTE, Long.parseLong(request.getParameter(WIN_LEVEL_ATTRIBUTE)));
        request.getSession().setAttribute(RATE_ATTRIBUTE, rateService.getAllUserRates(((Person)request.getSession().getAttribute(PERSON_ATTRIBUTE)).getId()));

        page = pageManager.getProperty(PageManager.PATH_PAGE_RATE);
        return page;
    }
}
