package com.shmouradko.totalizator.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by test on 16.01.2017.
 */
public interface ICommand {
    /**
     * Main method which contains validation of information and receiving data in according of request
     *
     * @param request request for processing
     * @return Page for returning after data processing
     */
    String execute(HttpServletRequest request);
}
