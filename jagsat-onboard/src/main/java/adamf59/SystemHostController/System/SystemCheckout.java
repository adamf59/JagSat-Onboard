/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*
*  Build: 3.21.19a
*/
package adamf59.SystemHostController.System;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.Subsystems.Communications.Communications;
import adamf59.SystemHostController.Subsystems.Communications.Transmit;

public class SystemCheckout extends Command {

    public SystemCheckout() {
        super("SYSTEM_CHECKOUT");
    }

    
    @Override
    public void init() {
        Console.printInfo("====System Check====");
        Console.printOk("Disabling Subsystems Temporarily...");
            SystemHost.getAvionics().suspendSubsystem();
           // SystemHost.getCommunications().suspendSubsystem();
    }

    @Override
    public void execute() {

        Console.printInfo("Checking Serial Connections...");
        Console.printInfo("TX Test...");
        SystemHost.getSchedulerService().scheduleTask(new Transmit("Jaguar Flight Systems"), SchedulerService.PRIORITY_LOW);

        sleep(4000);

            reiterate();
    }
    
    
    


}