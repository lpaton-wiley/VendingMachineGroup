import controller.VendingMachineController;
import dao.VendingMachineDAO;
import dao.VendingMachineDaoFileImpl;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.VendingMachineView;

public class App {

    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        VendingMachineView myView = new VendingMachineView(myIo);
        // Instantiate the DAO
        VendingMachineDAO myDao = new VendingMachineDaoFileImpl();
        // Instantiate the Audit DAO
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        //VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        VendingMachineController controller = new VendingMachineController(myView, myDao);
        // Kick off the Controller
        controller.run();
    }
}
