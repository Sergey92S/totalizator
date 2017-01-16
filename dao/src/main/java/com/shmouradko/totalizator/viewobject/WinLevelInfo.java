package com.shmouradko.totalizator.viewobject;

import com.shmouradko.totalizator.entity.WinLevel;

/**
 * Created by Revotech on 10.01.2017.
 */
public class WinLevelInfo {
    private float coefficient;
    private WinLevel.BetType bet;

    public WinLevelInfo(float coefficient, WinLevel.BetType bet){
        this.coefficient = coefficient;
        this.bet = bet;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public WinLevel.BetType getBet() {
        return bet;
    }
}
