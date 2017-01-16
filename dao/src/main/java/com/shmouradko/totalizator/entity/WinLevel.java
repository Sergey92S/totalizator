package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 09.01.2017.
 */
public class WinLevel extends Component{
    private float coefficient;
    private BetType bet;

    public enum BetType {
        WIN, DEFEAT, DRAW
    }

    public WinLevel(long id, float coefficient, BetType bet){
        super(id);
        this.coefficient = coefficient;
        this.bet = bet;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public BetType getBet() {
        return bet;
    }
}
