package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.service.CompetitionService;
import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by test on 08.01.2017.
 */
public class LogoutCommand extends ActionCommand {
    private String page;

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        CompetitionService competitionService = CompetitionService.getInstance();
        request.getSession().setAttribute(RESULT_ATTRIBUTE, competitionService.getAllGames());
        request.getSession().setAttribute(TOTAL_COUNT_ATTRIBUTE, competitionService.getAllGames().size());
        page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION);
        return page;
    }
}
