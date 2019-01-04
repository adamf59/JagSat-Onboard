package adamf59.SystemHostController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import adamf59.Core.Command;
import adamf59.SystemHostController.Subsystems.Avionics.Avionics;
import adamf59.SystemHostController.Subsystems.Avionics.BallastControl;
import adamf59.SystemHostController.Subsystems.Communications.Communications;
import adamf59.SystemHostController.System.DispatcherService;
import adamf59.SystemHostController.System.SchedulerService;

public class SystemHost {
    
    public static Avionics s_avionics;
    public static Communications s_communications;


    public static SchedulerService c_schedulerService;
    public static DispatcherService c_dispatcherService;


    public static void main(String[] args) throws Exception {
        consolePrintln("OK", "JagSat Flight Computer v1.0");
        consolePrintln("OK", "Written by Adam Frank, deployed by Windham High School JagSat Team");

        sys_init();
        

    }


    public static int sys_init() {
        consolePrintln("OK", "System is now initalizing");
        try {
            c_schedulerService = new SchedulerService();
            c_dispatcherService = new DispatcherService();

            s_avionics = new Avionics(0);
            s_communications = new Communications(1);


         

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

    public static void sys_start() {

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