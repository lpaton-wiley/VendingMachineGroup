package dao;

import dto.Item;

import java.math.BigDecimal;
import java.util.Map;

public interface VendingMachineDAO {

      public void buyItem(String itemName) throws NoRemainingInventoryException ;

      public Map<String, Item> getInventory ();

      public void setInventory ();

      BigDecimal getPrice(String selection);
}
