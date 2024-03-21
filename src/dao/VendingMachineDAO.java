package dao;

import dto.Item;

import java.math.BigDecimal;
import java.util.Map;

public interface VendingMachineDAO {

      public void buyItem(String itemName) throws NoRemainingInventoryException, VendingMachinePersistenceException ;

      public Map<String, Item> getInventory () throws VendingMachinePersistenceException;

      public void setInventory () throws VendingMachinePersistenceException;

      BigDecimal getPrice(String selection);
}
