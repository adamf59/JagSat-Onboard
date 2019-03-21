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
        Console.printOk("Initializing System Dispatcher Service");

        try {
            instanceThread.start();
        } catch (Exception e) {
            Console.printErr("Exception thrown in dispatcher initialization: " + " >> " + e.getCause());

        }
        Console.printOk("System Dispatcher Initialized Success");

    }
    
    @SuppressWarnings("static-access")
    @Override
    public void run() {

        while(dispatcher_master_loop) {
            try {

                if(CURRENT_PID < SystemHost.getSchedulerService().TOP_PID) {
                    Console.printInfo("DispatcherSerivce: Executing Task with PID " + CURRENT_PID);
                    SystemHost.getSchedulerService().getTask(CURRENT_PID).getCommand().init();
                    SystemHost.getSchedulerService().getTask(CURRENT_PID).getCommand().startThread();
                    CURRENT_PID++;
                }
      
                
                


                instanceThread.sleep(500);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}