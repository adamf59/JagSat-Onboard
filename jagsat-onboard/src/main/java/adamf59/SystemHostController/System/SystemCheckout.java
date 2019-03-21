package adamf59.SystemHostController.System;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;

public class SystemCheckout extends Command {

    public SystemCheckout() {
        super("SYSTEM_CHECKOUT");
    }

    
    @Override
    public void init() {
        SystemHost.consolePrintln("OK", "====System Check====");
        SystemHost.consolePrintln("OK", "Disabling Subsystems Temporarily...");
            SystemHost.getAvionics().suspendSubsystem();
            SystemHost.getCommunications().suspendSubsystem();
    }

    @Override
    public void execute() {

            
    }

    
    


}