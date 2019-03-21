/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.System;

import java.util.ArrayList;

import adamf59.Core.Command;
import adamf59.Core.Schedulable;
import adamf59.SystemHostController.SystemHost;

public class SchedulerService {

    private final ArrayList<Schedulable> TASK_ARRAY;

    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_MED = 2;
    public static final int PRIORITY_LOW = 1;


    int TOP_PID = 0;

    public SchedulerService() {
        TASK_ARRAY = new ArrayList<Schedulable>();
       
    }

    public Schedulable getTask(int PID) {
        return TASK_ARRAY.get(PID);
    }

    public int scheduleTask(Command c, int priority) {
        TASK_ARRAY.add(new Schedulable(priority, c));
        Console.printInfo("SchedulerService: Scheduling task with PID: " + TOP_PID + " and command " + c.getCommandName());

        TOP_PID++;
        
        return TOP_PID-1;
    }

    public void unscheduleTask(int PID) {
        TASK_ARRAY.remove(PID);
    }


}