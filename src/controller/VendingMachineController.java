package controller;

import dao.VendingMachineDAO;
import dao.VendingMachineDaoFileImpl;
import ui.VendingMachineView;

import java.util.List;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDaoFileImpl dao;

    public VendingMachineController(VendingMachineView view,  VendingMachineDaoFileImpl dao){
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

            while (keepGoing) {

                getMenuSelection();

                switch (menuSelection) {

                    default:
                        unknownCommand();
                }
            }
            exitMessage();


    }

    private void getMenuSelection() {
        view.printMenuAndGetSelection(dao.getInventory());
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
