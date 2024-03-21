package controller;

import dao.NoRemainingInventoryException;
import dao.VendingMachineDAO;
import ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDAO dao;

    public VendingMachineController(VendingMachineView view,  VendingMachineDAO dao){
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        dao.setInventory();
        
        while (keepGoing) {

                view.printMenu(dao.getInventory());
                BigDecimal money = view.getMoneyAmount();
                String selection = view.getSelection().toUpperCase();
                BigDecimal price = dao.getPrice(selection);

                if (isPossible(money, price)) {
                    try {
                        dao.buyItem(selection);
                        view.displaySuccessfulTransaction();
                        BigDecimal change = getChange(money, price);
                        view.displayChange(change);
                    } catch (NoRemainingInventoryException e){
                        view.displayErrorMessage(e.getMessage());
                    }

                } else {
                     view.displayErrorMessage("You don't have enough money!");
                }
                
                String input = view.getUserInput("Would you like anything else (Y/N)?");

                switch (input.toLowerCase()) {
                    case "y":
                        break;
                    case "n":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
    }

    private boolean isPossible(BigDecimal money, BigDecimal price){
        return (money.compareTo(price) >= 0);
    }
    
    private BigDecimal getChange(BigDecimal money, BigDecimal price) {
        return money.subtract(price);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
