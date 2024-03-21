package dao;

import dto.*;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDAO {

    private Map<String, Item> inventory = new HashMap<>();

    public VendingMachineDaoFileImpl(){}

    @Override
    public Map<String, Item> getInventory () {
        return inventory;
    }

    @Override
    public void setInventory () {
        BigDecimal chipsPrice = new BigDecimal("2.50");
        chipsPrice.setScale(2);
        BigDecimal cookiesPrice = new BigDecimal("3.95");
        cookiesPrice.setScale(2);
        BigDecimal colaPrice = new BigDecimal("3.00") ;
        colaPrice.setScale(2);

        Item chips = new Item("CHIPS", chipsPrice, 10);
        Item cookies = new Item("COOKIES", cookiesPrice, 4);
        Item cola = new Item("COLA", colaPrice, 0);

        inventory.put("CHIPS", chips);
        inventory.put("COOKIES", cookies);
        inventory.put("COLA", cola);

    }


    @Override
    public void buyItem(String itemName) throws NoRemainingInventoryException {
        Item item = inventory.get(itemName);
        int remaining = item.getRemaining();

        if (remaining == 0) {
            NoRemainingInventoryException e = new NoRemainingInventoryException("There are none of these items left - cannot purchase.");
            throw e;
        }
        else {
              item.setRemaining(remaining--);
              inventory.replace(itemName, item);
        }
        
    }

    @Override
    public BigDecimal getPrice(String name){
        return inventory.get(name).getPrice();
    }


}

