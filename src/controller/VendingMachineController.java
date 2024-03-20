package controller;

import dao.NoRemainingInventoryException;
import dao.VendingMachineDAO;
import ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDAO dao;

    public VendingMachineController(VendingMachineView view, VendingMachineDAO dao) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
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
            }

            switch (menuSelection) {

                default:
                    unknownCommand();
            }

            exitMessage();
        } catch (NoRemainingInventoryException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private boolean isPossible(BigDecimal money, BigDecimal price) {
        return (money.compareTo(price) <= 0);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void successfulTransaction() {
        view.displaySuccessfulTransaction();
    }

    private BigDecimal getChange(BigDecimal money, BigDecimal price) {
        BigDecimal change = money.subtract(price);
        view.displayChange(change);
        return change;
    }
}


