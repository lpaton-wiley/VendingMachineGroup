package dao;

import dto.*;

import java.io.*;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDAO {

    private Map<String, Integer> inventory = new HashMap<>();

    public VendingMachineDaoFileImpl(){
    }

    public Map<String, Integer> getInventory () {
        return  inventory;
    }

    @Override
    public void buyItem(String item) throws NoRemainingInventoryException {
        int remaining = inventory.get(item);

        if (remaining == 0) {
            NoRemainingInventoryException e = new NoRemainingInventoryException("There are none of these items left - cannot purchase.");
            throw e;
        }
        else {
            inventory.replace(item, remaining--);
        }
        
    }


}

