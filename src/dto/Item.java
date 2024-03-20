package dto;

import java.math.BigDecimal;

public class Item {
    private final String cola;
    private final String chips;
    private final String cookies;

    private BigDecimal colaPrice;
    private BigDecimal chipsPrice;
    private BigDecimal cookiesPrice;

    private int colaCount;
    private int chipsCount;
    private int cookiesCount;

    public Item(String cola, String chips, String cookies) {
        this.cola = cola;
        this.chips = chips;
        this.cookies = cookies;
    }

    public String getCola() {
        return cola;
    }

    public String getChips() {
        return chips;
    }

    public String getCookies() {
        return cookies;
    }

    public BigDecimal getChipsPrice() {
        return chipsPrice;
    }

    public void setChipsPrice(BigDecimal chipsPrice) {
        this.chipsPrice = chipsPrice;
    }

    public BigDecimal getCookiesPrice() {
        return cookiesPrice;
    }

    public void setCookiesPrice(BigDecimal cookiesPrice) {
        this.cookiesPrice = cookiesPrice;
    }

    public BigDecimal getColaPrice() {
        return colaPrice;
    }

    public void setColaPrice(BigDecimal colaPrice) {
        this.colaPrice = colaPrice;
    }
}
