package dto;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private BigDecimal price;
    private int remaining;


    public Item(String name, BigDecimal price, int remaining) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
