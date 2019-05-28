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
            for(int i = 0; i < 10; i++) {
                Console.progressPercentage(i, 10);
                Thread.sleep(90);
            }
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());


            SystemHost.getCommunications().transmit("AT&K0");
            for(int i = 0; i < 10; i++) {
                Console.progressPercentage(i, 10);
                Thread.sleep(90);
            }
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());


            SystemHost.getCommunications().transmit("AT+SBDWT=");
            for(int i = 0; i < 10; i++) {
                Console.progressPercentage(i, 10);
                Thread.sleep(90);
            }
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());


            SystemHost.getCommunications().transmit("AT+SBDIX");
            for(int i = 0; i < 5; i++) {
                Console.progressPercentage(i, 5);
                Thread.sleep(3000);
            }
            Console.printInfo("RockBlock Response: " + SystemHost.getCommunications().getLastResponse());








        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}