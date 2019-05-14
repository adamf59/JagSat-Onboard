package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class Transmit extends Command {

    private String data = "";

    /**
     * Command to transmit data from the Communications Subsystem
     * @param data
     */
    public Transmit(String data) {
        super("TRANSMIT");
        this.data = data;
    }

    @Override
    public void init() {

    }

    @Override
    public void execute() {
        if (SystemHost.isJFSLVerified()) { // ONLY TRANSMIT IF RUN FROM FLT COMPUTER

            try {
                SystemHost.getCommunications().transmit(data);
            } catch (IllegalStateException | IOException e) {
                Console.printErr("Transmit: Transmission failed. Reason: " + e.getMessage());
            }


        }
    }

}