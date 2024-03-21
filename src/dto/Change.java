package dto;

import java.math.BigDecimal;

public class Change {

    public enum Coins {
        PENNY(0.01), NICKLE(0.05), DIME(0.10), QUARTER(0.25);

        private final double coinValue;


        Coins(double coinValue) {
            this.coinValue = coinValue;
        }

        public double getCoinValue() {
            return coinValue;
        }
    }

    private double pennies;
    private double nickels;
    private double dimes;
    private double quarters;

    public Change(int changeInPennies) {
        calculateChange(changeInPennies);
    }


    private void calculateChange(double changeInPennies) {
        for (Coins coin : Coins.values()) {
            double coinValue = coin.getCoinValue();
            switch (coin) {
                case QUARTER:
                    quarters = changeInPennies / coinValue;
                    changeInPennies %= coinValue;
                    break;
                case DIME:
                    dimes = changeInPennies / coinValue;
                    changeInPennies %= coinValue;
                    break;
                case NICKLE:
                    nickels = changeInPennies / coinValue;
                    changeInPennies %= coinValue;
                    break;
                case PENNY:
                    pennies = changeInPennies;
                    break;
            }
        }
    }


    public double getPennies() {
        return pennies;
    }

    public double getNickels() {
        return nickels;
    }

    public double getDimes() {
        return dimes;
    }

    public double getQuarters() {
        return quarters;
    }

    public BigDecimal getTotalChange() {
        double totalPennies = pennies + nickels * Coins.NICKLE.getCoinValue() +
                dimes * Coins.DIME.getCoinValue() + quarters * Coins.QUARTER.getCoinValue();
        return BigDecimal.valueOf(totalPennies);
    }

    public void printChange() {
        System.out.println("Your change is: £" + getTotalChange());
        System.out.println("Coins: ");

        for (Coins coin : Coins.values()) {
            double count;
            switch (coin) {
                case QUARTER:
                    count = quarters;
                    break;
                case DIME:
                    count = dimes;
                    break;
                case NICKLE:
                    count = nickels;
                    break;
                case PENNY:
                    count = pennies;
                    break;
                default:
                    count = 0;
            }
            if (count > 0) {
                System.out.println(coin.name() + ": " + count);
            }
        }
    }
}