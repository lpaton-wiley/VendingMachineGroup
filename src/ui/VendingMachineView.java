package ui;

import java.util.List;

public class VendingMachineView {

        private UserIO io;

        public VendingMachineView(UserIO io){
            this.io = io;
        }

        public int printMenuAndGetSelection() {
            io.print("Main Menu");
            io.print("1. List Addresses");
            io.print("2. Create New Address");
            io.print("3. View a Address");
            io.print("4. Remove a Address");
            io.print("5. View Address Count");
            io.print("6. Exit");

            return io.readInt("Please select from the above choices.", 1, 6);
        }

        public Address getNewAddressInfo() {
            String name = io.readString("Please enter name");
            String streetNumber = io.readString("Please enter street number");
            String streetName = io.readString("Please enter street Name");
            String suburb = io.readString("Please enter suburb");
            String state = io.readString("Please enter state");
            String postcode = io.readString("Please enter postcode");

            Address currentAddress = new Address(name);
            currentAddress.setStreetNumber(streetNumber);
            currentAddress.setStreetName(streetName);
            currentAddress.setSuburb(suburb);
            currentAddress.setState(state);
            currentAddress.setPostCode(postcode);

            return currentAddress;
        }

        public void displayCreateAddressBanner() {
            io.print("=== Create Address ===");
        }

        public void displayCreateSuccessBanner() {
            io.readString(
                    "Address successfully created.  Please hit enter to continue");
        }

        public void displayAddressList(List<Address> addresses) {
            for (Address currentAddress : addresses) {
                String addressInfo =
                        currentAddress.getName() + ": "  +
                                currentAddress.getStreetNumber() +
                                currentAddress.getStreetName() + "\n" +
                                currentAddress.getSuburb() +", " +
                                currentAddress.getState() + " " +
                                currentAddress.getPostCode();
                io.print(addressInfo);
            }
            io.readString("Please hit enter to continue.");
        }

        public void displayDisplayAllBanner() {
            io.print("=== Display All Addresses ===");
        }

        public void displayDisplayAddressBanner () {
            io.print("=== Display Address ===");
        }

        public void displayAddressCount (List<Address> addresses) {
            io.print("=== Display Address Count ===");
            String count = Integer.toString(addresses.size()) ;
            io.print(count);
        }

        public String getAddressIdChoice() {
            return io.readString("Please enter the Address name.");
        }


        public void displayAddress(Address address) {
            if (address != null) {
                io.print(address.getName());
                io.print(address.getStreetNumber() + " " + address.getStreetName() + ", " + address.getSuburb());
                io.print(address.getState() + ", " + address.getPostCode());
                io.print("");
            } else {
                io.print("No such address.");
            }
            io.readString("Please hit enter to continue.");

        }

        public void displayRemoveAddressBanner () {
            io.print("=== Remove Address ===");
        }

        public void displayRemoveResult(Address addressRecord) {
            if(addressRecord != null){
                io.print("Address successfully removed.");
            }else{
                io.print("No such address.");
            }
            io.readString("Please hit enter to continue.");
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
}
