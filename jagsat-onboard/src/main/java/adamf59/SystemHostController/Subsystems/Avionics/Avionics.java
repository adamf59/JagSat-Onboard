package adamf59.SystemHostController.Subsystems.Avionics;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;

public class Avionics extends Subsystem {

    public Avionics(int id) {
        super("JAGSAT_AVIONICS_SUBSYSTEM", id);

    }

    @Override
    public void init() {
        SystemHost.consolePrintln("OK", "Initializing Avionics Subsystem");

    }


    @Override
    public void execute() {
           // SystemHost.consolePrintln("OK", "Avionics subsystem updating...");
            try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeAlways() {
        
    }


}