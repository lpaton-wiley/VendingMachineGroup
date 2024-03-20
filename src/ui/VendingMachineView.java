package ui;

import java.util.List;
import java.util.Map;

public class VendingMachineView {

        private UserIO io;

        public VendingMachineView(UserIO io){
            this.io = io;
        }

        public void printMenuAndGetSelection(Map<String, Integer> inventory) {
            io.print("Menu");
            io.print(inventory.toString());
            // print items and prices
            // ask for money amount
            // ask for selection
            // get result

        }

        public void getOrder() {
            float amount = io.readFloat("Please enter money amount:");
            int selection = io.readInt("Please enter selection:" );

            // call method that decides if possible or gets change
        }

        public void displayCreateAddressBanner() {
            io.print("=== Create Address ===");
        }

        public void displayCreateSuccessBanner() {
            io.readString(
                    "Address successfully created.  Please hit enter to continue");
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
