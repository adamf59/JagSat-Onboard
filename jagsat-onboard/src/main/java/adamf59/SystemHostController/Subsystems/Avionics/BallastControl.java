/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Avionics;

import adamf59.Core.Command;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class BallastControl extends Command {

    public BallastControl() {
        super("BALLAST_CONTROL");
    }
    
    @Override
    public void init() {

    }

    @Override
    public void execute() {
           Console.printInfo("Recieved Ballast Drop Command"); 
    }

   
}