package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 11.01.2017.
 */
public class Rate extends Component {
    private double amount;

    public Rate(long id, double amount) {
        super(id);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
