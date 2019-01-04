package adamf59.SystemHostController.Subsystems.Communications;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;

public class Communications extends Subsystem {

    public Communications(int id) {
        super("JAGSAT_COMMUNICATIONS_SUBSYSTEM", 1);
    }

    @Override
    public void init() {
        SystemHost.consolePrintln("OK", "Initializing Communications Subsystem");

    }

    @Override
    public void execute() {
        
    }

    @Override
    public void executeAlways() {

    }

    

}