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

        Item chips = new Item("Chips", chipsPrice, 10);
        Item cookies = new Item("Cookies", cookiesPrice, 4);
        Item cola = new Item("Cola", colaPrice, 5);

        inventory.put("Chips", chips);
        inventory.put("Cookies", cookies);
        inventory.put("Cola", cola);

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


}

