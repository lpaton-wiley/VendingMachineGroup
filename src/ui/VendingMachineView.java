package ui;

import dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachineView {

        private UserIO io;

        public VendingMachineView(UserIO io){
            this.io = io;
        }

        public void printMenu(Map<String, Item> inventory) {
            io.print("Menu");
            io.print(inventory.toString());

        }

        public BigDecimal getMoneyAmount() {
            return io.readDecimal("How much money do you have?");
        }

        public String getSelection() {
            return io.readString("Which item do you want?");
        }

        public void displayExitBanner() {
            io.print("Good Bye!!!");
        }

        public void displayUnknownCommandBanner() {
            io.print("Unknown Command!!!");
        }

        public void displayErrorMessage(String errorMsg) {
            io.print("=== ERROR ===");
            io.print(errorMsg);
        }
        
}
