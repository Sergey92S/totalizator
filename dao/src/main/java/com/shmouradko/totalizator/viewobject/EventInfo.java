package com.shmouradko.totalizator.viewobject;

/**
 * Created by test on 09.01.2017.
 */
public class EventInfo {
    private String name;
    private boolean home;

    public EventInfo(String name, boolean home){
        this.name = name;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public boolean isHome() {
        return home;
    }
}
