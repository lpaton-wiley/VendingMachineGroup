package dto;

public enum Change {

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

    private int coinValue;

    private Change(int denomination){
        this.coinValue = denomination;
    }

    public int getDenomination(){
        return coinValue;
    }
}
