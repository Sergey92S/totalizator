package com.shmouradko.totalizator.command;

import com.shmouradko.totalizator.service.CompetitionService;
import com.shmouradko.totalizator.tool.PageManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by test on 23.11.2016.
 */
public class CompetitionCommand extends ActionCommand implements ICommand {
    private static Logger LOGGER = Logger.getLogger(CompetitionCommand.class);
    private String page;

    @Override
    public String execute(HttpServletRequest request) {
        CompetitionService competitionService = CompetitionService.getInstance();
        request.getSession().setAttribute(PERSON_TYPE_ATTRIBUTE,
                LoginCommand.ClientType.GUEST);
        request.getSession().setAttribute(RESULT_ATTRIBUTE, competitionService.getAllGames());
        request.getSession().setAttribute(TOTAL_COUNT_ATTRIBUTE, competitionService.getAllGames().size());
        page = pageManager.getProperty(PageManager.PATH_PAGE_COMPETITION);
        LOGGER.log(Level.DEBUG, page);
        return page;
    }

}
