package dao;

import dto.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDAO {

    private Map<String, Item> inventory = new HashMap<>();
    private String ROSTER_FILE = "VendingMachine.txt";

    public VendingMachineDaoFileImpl(){}

    @Override
    public Map<String, Item> getInventory () throws VendingMachinePersistenceException {
        loadItemBook();
        return inventory;
    }

    @Override
    public void setInventory ()  throws VendingMachinePersistenceException {
        writeItemBook();
    }


    @Override
    public void buyItem(String itemName) throws NoRemainingInventoryException, VendingMachinePersistenceException {
        Item item = inventory.get(itemName);
        int remaining = item.getRemaining();

        if (remaining == 0) {
            throw new NoRemainingInventoryException("There are none of these items left - cannot purchase.");
        }
        else {
              item.setRemaining(remaining - 1);
              inventory.replace(itemName, item);
              writeItemBook();
        }


        
    }

    @Override
    public BigDecimal getPrice(String name){
        return inventory.get(name).getPrice();
    }


    private Item unmarshallItem(String itemAsText){
        String[] itemTokens = itemAsText.split("::");

        // Given the pattern above, the item Id is in index 0 of the array.
        String name = itemTokens[0];

        // Which we can then use to create a new Item object to satisfy
        // the requirements of the Item constructor.
        Item itemFromFile = new Item(name);

        // However, there are 3 remaining tokens that need to be set into the
        // new item object. Do this manually by using the appropriate setters.

        itemFromFile.setPrice(new BigDecimal(itemTokens[1]));

        itemFromFile.setRemaining(Integer.parseInt(itemTokens[2]));

        // We have now created a item! Return it!
        return itemFromFile;
    }

    private void loadItemBook() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("VendingMachine.txt")));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentItem holds the most recent item unmarshalled
        Item currentItem;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Item object by calling the unmarshallItem method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();

            // unmarshall the line into a Item
            if (!(currentLine.equals(""))){
                currentItem = unmarshallItem(currentLine);
                String name = currentItem.getName();
                inventory.put(name, currentItem);
            }

            // We are going to use the item id as the map key for our item object.
            // Put currentItem into the map using item id as the key
        }
        // close scanner
        scanner.close();
    }

    private String marshallItem(Item item){
        // We need to turn a Item object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the item id, since that's supposed to be first.
        String itemAsText = item.getName() + "::";

        // add the rest of the properties in the correct order:

        // LastName
        itemAsText += item.getPrice() + "::";

        // Cohort - don't forget to skip the DELIMITER here.
        itemAsText += item.getRemaining() ;


        // We have now turned a item to text! Return it!
        return itemAsText;
    }

    /**
     * Writes all items in the roster out to a ROSTER_FILE.  See loadItemBook
     * for file format.
     *
     * @throws VendingMachinePersistenceException if an error occurs writing to the file
     */
    private void writeItemBook() throws VendingMachinePersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }

        // Write out the Item objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the item map,
        // get the Collection of Items and iterate over them but we've
        // already created a method that gets a List of Items so
        // we'll reuse it.
        String itemAsText;
        Collection<Item> itemList = this.getInventory().values();

        for (Item currentItem : itemList) {
            // turn a Item into a String
            itemAsText = marshallItem(currentItem);
            // write the Item object to the file
            out.println(itemAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    
    
}

