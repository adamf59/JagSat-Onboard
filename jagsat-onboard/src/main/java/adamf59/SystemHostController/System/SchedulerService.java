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

        /**
         * Items with a high priority, should be executed almost immediately
         */
    public static final int PRIORITY_HIGH = 3;
      /**
         * Items with a medium priority, are executed behind high priority tasks
         */
    public static final int PRIORITY_MED = 2;
      /**
         * Items with a low priority, are executed at the bottom of the queue, not important, non critical
         */
    public static final int PRIORITY_LOW = 1;


    int TOP_PID = 0;

    /**
     * Creates a new instance of the scheduler service
     */
    public SchedulerService() {
        TASK_ARRAY = new ArrayList<Schedulable>();
       
    }
    /**
     * Gets the Schedulable instance for a PID
     * @param PID
     * @return Schedulable 
     */
    public Schedulable getTask(int PID) {
        return TASK_ARRAY.get(PID);
    }
        /**
         * Schedules a task for execution
         * @param Command
         * @param Priority
         * @return Scheduled PID of task
         */
    public int scheduleTask(Command c, int priority) {
        TASK_ARRAY.add(new Schedulable(priority, c));
        Console.printInfo("SchedulerService: Scheduling task with PID: " + TOP_PID + " and command " + c.getCommandName());

        TOP_PID++;
        
        return TOP_PID-1;
    }
        /**
         * Removes a task from the task queue
         * @param PID
         */
    public void unscheduleTask(int PID) {
        TASK_ARRAY.remove(PID);
    }


}