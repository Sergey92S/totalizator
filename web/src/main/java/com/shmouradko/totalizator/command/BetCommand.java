package com.shmouradko.totalizator.command;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Revotech on 12.01.2017.
 */
public class BetCommand extends ActionCommand {
    private String page;

    @Override
    public String execute(HttpServletRequest request) {
//        RateService rateService = new RateService();
//        rateService.createRate((Person)request.getSession().getAttribute(PERSON_ATTRIBUTE), request.getSession().getAttribute(MATCH_ATTRIBUTE));
//        page = pageManager.getProperty(PageManager.PATH_PAGE_MATCH_USER);
        return page;
    }
}
