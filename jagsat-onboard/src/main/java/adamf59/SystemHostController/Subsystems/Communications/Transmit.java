package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;

public class Transmit extends Command {

    private String data = "";

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
                SystemHost.consolePrintln("ERR", "Transmission failed. Reason: " + e.getMessage());
            }


        }
    }

}