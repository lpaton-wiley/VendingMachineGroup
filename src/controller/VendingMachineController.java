package controller;

import dao.NoRemainingInventoryException;
import dao.VendingMachineDAO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDAO dao;
    private UserIOConsoleImpl io;

    public VendingMachineController(VendingMachineView view,  VendingMachineDAO dao){
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        String input;

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
                    view.displaySuccessfulTransaction();
                    view.displayChange(change);
                }
                
                input = io.readString("Go Again?");

                switch (input) {
                    case "y":
                        System.out.println("Ok keep going");
                        break;
                    case "n":
                        keepGoing = false;
                        exitMessage();
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
        BigDecimal change = money.subtract(price);
        view.displayChange(change);
        return change;
    }


    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
