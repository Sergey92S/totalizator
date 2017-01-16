package com.shmouradko.totalizator.command.factory;

import com.shmouradko.totalizator.command.ActionCommand;
import com.shmouradko.totalizator.creator.CommandCreator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by test on 23.11.2016.
 */
public class ActionFactory {
    //MESSAGES
    private static String MESSAGE_WRONG_ACTION = ": command not found or wrong!";

    //ACTION COMMANDS
    private static String COMMAND_ACTION = "command";
    private static String SUBMIT_ACTION = "multisubmit";

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        String action;

        if (request.getParameter(SUBMIT_ACTION)==null){
            action = request.getParameter(COMMAND_ACTION);
        }else {
            action = request.getParameter(SUBMIT_ACTION);
        }

        try {
            CommandCreator currentEnum = CommandCreator.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MESSAGE_WRONG_ACTION);
        }
        return current;
    }
}
