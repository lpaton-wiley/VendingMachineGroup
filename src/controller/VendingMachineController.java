package controller;

import dao.NoRemainingInventoryException;
import dao.VendingMachineDAO;
import ui.UserIO;
import ui.UserIOConsoleImpl;
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
        
        try {

            while (keepGoing) {

                view.printMenu(dao.getInventory());
                BigDecimal money = view.getMoneyAmount();
                String selection = view.getSelection();
                BigDecimal price = dao.getInventory().get(selection).getPrice();

                if (isPossible(money, price)) {
                    dao.buyItem(selection);
                } else {
                    BigDecimal change = getChange(money, price);
                    view.displayChange(change);
                }
                
                String input = view.getUserInput();

                switch (input) {
                    case "y":
                        System.out.println("Ok keep going");
                        break;
                    case "n":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (NoRemainingInventoryException e){
            view.displayErrorMessage(e.getMessage());
        }

    }

    private boolean isPossible(BigDecimal money, BigDecimal price){
        return (money.compareTo(price) <= 0);
    }

    private void successfulTransaction() {
        view.displaySuccessfulTransaction();
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
