package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 09.01.2017.
 */
public class Team extends Component{
    private String name;

    public Team(long id, String name){
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
