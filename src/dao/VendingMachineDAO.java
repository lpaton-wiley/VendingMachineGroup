package dao;

public interface VendingMachineDAO {

      public void buyItem(String itemName) throws NoRemainingInventoryException ;
    
}
