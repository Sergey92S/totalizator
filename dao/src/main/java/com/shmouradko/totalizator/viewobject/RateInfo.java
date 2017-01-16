package com.shmouradko.totalizator.viewobject;

import com.shmouradko.totalizator.entity.Match;
import com.shmouradko.totalizator.entity.WinLevel;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Revotech on 12.01.2017.
 */
public class RateInfo {
    private List<EventInfo> eventInfoList;
    private Timestamp time;
    private float coefficient;
    private WinLevel.BetType bet;
    private Match.ResultType result;
    private double amount;

    public RateInfo(List<EventInfo> eventInfoList, Timestamp time, float coefficient, WinLevel.BetType bet, Match.ResultType result, double amount){
        this.eventInfoList = eventInfoList;
        this.time = time;
        this.coefficient = coefficient;
        this.bet = bet;
        this.result = result;
        this.amount = amount;
    }

    public List<EventInfo> getEventInfoList() {
        return eventInfoList;
    }

    public Timestamp getTime() {
        return time;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public WinLevel.BetType getBet() {
        return bet;
    }

    public Match.ResultType getResult() {
        return result;
    }

    public double getAmount() {
        return amount;
    }
}
