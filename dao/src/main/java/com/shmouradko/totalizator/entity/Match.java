package com.shmouradko.totalizator.entity;

import java.sql.Timestamp;

/**
 * Created by Revotech on 09.01.2017.
 */
public class Match extends Component{
    private String name;
    private Timestamp time;
    private ResultType result;

    public enum ResultType {
        WIN, DEFEAT, DRAW, EMPTY
    }

    public Match(long id, String name, Timestamp time, ResultType result){
        super(id);
        this.name = name;
        this.time = time;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTime() {
        return time;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }
}
