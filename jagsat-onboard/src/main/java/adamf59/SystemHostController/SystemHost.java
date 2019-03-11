/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import adamf59.SystemHostController.IO.GPIO;
import adamf59.SystemHostController.Subsystems.Avionics.Avionics;
import adamf59.SystemHostController.Subsystems.Avionics.BallastControl;
import adamf59.SystemHostController.Subsystems.Communications.Communications;
import adamf59.SystemHostController.System.DispatcherService;
import adamf59.SystemHostController.System.SchedulerService;
import adamf59.SystemHostController.System.SystemController;

public class SystemHost {
    
    public static Avionics s_avionics;
    public static Communications s_communications;


    public static SchedulerService c_schedulerService;
    public static DispatcherService c_dispatcherService;
    public static SystemController c_systemController;
    

    public static void main(String[] args) throws Exception {
        consolePrintln("OK", "JagSat Flight Computer v1.0");
        consolePrintln("OK", "Written by Adam Frank, deployed by Windham High School JagSat Team");
        
        if(Arrays.toString(args).contains("-JFSL")) {
            consolePrintln("OK", "Verified Jaguar Flight Systems Launcher... Hello JFSL!");

        }



        sys_init();
        
        try {

            consolePrintln("OK", "Handing control to System Controller...");

            c_systemController.start();

        } catch(Exception e) {
            consolePrintln("OK", "System Host now destroying all systems.");

        }



    }


    public static int sys_init() {
        consolePrintln("OK", "System is now initalizing");
        try {
            c_schedulerService = new SchedulerService();
            c_dispatcherService = new DispatcherService();
            c_systemController = new SystemController();

            s_avionics = new Avionics(0);
            s_communications = new Communications(1);

            GPIO.initGPIOController();
         
            c_schedulerService.scheduleTask(new BallastControl(), 1);
            c_schedulerService.scheduleTask(new BallastControl(), 1);

            c_schedulerService.scheduleTask(new BallastControl(), 1);
            c_schedulerService.scheduleTask(new BallastControl(), 1);



        } catch(Exception e) {
                SystemHost.consolePrintln("ERR", "Exception thrown in system initialization: " + " >> " + e.getCause());
                e.printStackTrace();
            // something went wrong during initialization
            return 0; 
        }
        // initializing system was successful
        consolePrintln("OK", "System initialization complete");
        return 1;
    }

    public static void sys_destroy() {
        consolePrintln("WARN", "System is shutting down");

        s_avionics.destroySubsystem();
        s_communications.destroySubsystem();
        GPIO.shutdown();
    }
 

    public static void consolePrintln(String success, String message) {
        String timeStamp = new SimpleDateFormat("HH:mm:ss:SS").format(Calendar.getInstance().getTime());
        System.out.println("[   " + success + "   " + timeStamp + "   ] " + message);
    }

        /**
         * Get the avionics subsystem instance
         */
    public static Avionics getAvionics() {
        return s_avionics;
    }

        /**
         * Get the communications subsystem instance
         */
    public static Communications getCommunications() {
        return s_communications;
    }

        /**
         * Get the active SchedulerService instance
         */
    public static SchedulerService getSchedulerService() {
        return c_schedulerService;
    }
   

}