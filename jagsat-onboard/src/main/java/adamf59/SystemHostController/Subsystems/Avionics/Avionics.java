/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Avionics;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class Avionics extends Subsystem {

    public Avionics(int id) {
        super("JAGSAT_AVIONICS_SUBSYSTEM", id);

    }

    @Override
    public void init() {
        Console.printInfo("Initializing Avionics Subsystem");

    }


    @Override
    public void execute() {
            Console.printInfo("Avionics subsystem updating...");
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