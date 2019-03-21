/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.System;

import adamf59.SystemHostController.SystemHost;

public class SystemController implements Runnable {

    private Thread instanceThread;

    public SystemController() {
        instanceThread = new Thread(this, "JAGSAT_SYSTEM_CONTROLLER");
        Console.printOk("Initializing System Controller");
    }

    public void start() throws Exception {
        try {
            instanceThread.start();
        } catch(Exception e) {
            throw(new Exception("The System Controller failed to start and take control. Terminating all systems..."));
        }
    }

    @Override
    public void run() {


        while(true) {

        }
    
    
    }



}