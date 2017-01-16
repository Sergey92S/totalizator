package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 09.01.2017.
 */
public class Event extends Component {
    private boolean home;

    public Event(long id, boolean home){
        super(id);
        this.home = home;
    }

    public boolean isHome() {
        return home;
    }

    //    public void setHome(boolean home) {
//        this.home = home;
//    }
}
