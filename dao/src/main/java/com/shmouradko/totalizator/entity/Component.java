package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 09.01.2017.
 */
public abstract class Component {
    private Long id;

    public Component(long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

}
