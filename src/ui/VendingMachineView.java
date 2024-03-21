package ui;

import dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VendingMachineView {

        private UserIO io;

        public VendingMachineView(UserIO io){
            this.io = io;
        }

        public void printMenu(Map<String, Item> inventory) {
            io.print("Menu");
            Set<String> items = inventory.keySet();
            for (String itemName: items) {
                Item item = inventory.get(itemName);
                int remaining = item.getRemaining();
                if (!(remaining == 0)){
                    io.print(itemName + ": " + item.getPrice().toString() + " (" + item.getRemaining() +" items left.) " );
                }
            }

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

    public String getUserInput(String prompt) {
        return io.readString(prompt);
    }

    public void displayChange(BigDecimal change) {
        System.out.println("Your change is: £ " + change);
    }

    public void displaySuccessfulTransaction() {
        io.print("=== THANK YOU ===");
    }
        
}
