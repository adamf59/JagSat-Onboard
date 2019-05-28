package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class Receive extends Command {

    public Receive() {
        super("RECEIVE");
    }

    @Override
    public void init() {

    }

    @Override
    public void execute() {
        try {
            SystemHost.getCommunications().transmit("AT");
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());
            SystemHost.getCommunications().transmit("AT&K0");
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());
            SystemHost.getCommunications().transmit("AT+SBDWT=");
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());
            SystemHost.getCommunications().transmit("AT+SBDIX");
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());








        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}