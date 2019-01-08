package adamf59.SystemHostController.System;

/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
import adamf59.SystemHostController.SystemHost;

public class DispatcherService implements Runnable {
    
    private Thread instanceThread;
    private boolean dispatcher_master_loop = true;

    int CURRENT_PID = 0;
    
    public DispatcherService() {

        instanceThread = new Thread(this, "JAGSAT_DISPATCHER_SERVICE");
        SystemHost.consolePrintln("OK", "Initializing System Dispatcher Service");

        try {
            instanceThread.start();
        } catch (Exception e) {
            SystemHost.consolePrintln("ERR", "Exception thrown in dispatcher initialization: " + " >> " + e.getCause());

        }
        SystemHost.consolePrintln("OK", "System Dispatcher Initialized Success");

    }
    
    @SuppressWarnings("static-access")
    @Override
    public void run() {

        while(dispatcher_master_loop) {
            try {

                if(CURRENT_PID < SystemHost.c_schedulerService.TOP_PID) {
                    SystemHost.consolePrintln("WARN", "Executing Task with PID " + CURRENT_PID);
                    SystemHost.c_schedulerService.getTask(CURRENT_PID).getCommand().startThread();
                    CURRENT_PID++;
                }
      
                
                


                instanceThread.sleep(500);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}