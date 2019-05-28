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
import adamf59.SystemHostController.Subsystems.Communications.Receive;
import adamf59.SystemHostController.Subsystems.Communications.Transmit;
import adamf59.SystemHostController.Subsystems.Sensors.BME280;

public class SystemCheckout extends Command {

    /**
     * Command responsible for testing all subsystems to ensure they are working
     * properly
     */
    public SystemCheckout() {
        super("SYSTEM_CHECKOUT");
    }

    @Override
    public void init() {
        Console.printInfo("====System Check====");
        Console.printOk("Disabling Subsystems Temporarily...");
        SystemHost.getAvionics().suspendSubsystem();
        SystemHost.getCommunications().suspendSubsystem();
    }

    @Override
    public void execute() {

        Console.printInfo("Checking Serial TXRX Connections...");
        SystemHost.getSchedulerService().scheduleTask(new Transmit("AT"), SchedulerService.PRIORITY_LOW);
        Console.printInfo("Awaiting new data");

        sleep(2000);
        if (SystemHost.getCommunications().getLastResponse().contains("OK")) {
            Console.printOk("Serial TXRX Test Passed. No issues detected.");
        } else {
            Console.printErr("Serial TXRX Test Failed. Data recieved was not expected. I got: "
                    + SystemHost.getCommunications().getLastResponse());
        }
        Console.printInfo("Checking BME280 Sensor");
        
        
        if(SystemHost.getBME280().test()) {
            Console.printOk("BME280 test was passed");
        } else {
            Console.printErr("BME280 test failed. check this device!");

        }

       


        Console.printInfo("====System Check Complete====");
        Console.printOk("Resuming Subsystems...");

       
        SystemHost.getSchedulerService().scheduleTask(new Receive(), SchedulerService.PRIORITY_HIGH);




            //SystemHost.getAvionics().resumeSubsystem();
            //SystemHost.getCommunications().resumeSubsystem();

    }
    
    
    


}