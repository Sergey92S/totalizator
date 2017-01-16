package com.shmouradko.totalizator.creator;

import com.shmouradko.totalizator.command.*;

/**
 * Created by test on 23.11.2016.
 */
public enum CommandCreator {
    COMPETITION {
        {
            this.command = new CompetitionCommand();
        }
    },
    LOGON {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SERIEA {
        {
            this.command = new MatchCommand();
        }
    },
    RATE {
        {
            this.command = new RateCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
