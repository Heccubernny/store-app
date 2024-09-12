package com.mama.pride.models;

public class Transaction {
    private int cid;
    private int amount;

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "cid=" + cid +
                ", amount=" + amount +
                ']';
    }

    public Transaction(int cid, int amount) {
        this.cid = cid;
        this.amount = amount;
    }

}
