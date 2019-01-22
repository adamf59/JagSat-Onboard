/**
 * [[[JAGSAT CORE]]]
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.Core;

    /**
     * Schedulable is used to tell the SchedulerService how and when to execute commands.
     * @author Adam Frank
     */
public class Schedulable {

    private int PRIORITY;
    private Command command;

        /**
         *  Creates a new schedulable instance
         * @param PRIORITY
         * @param command
         */
    public Schedulable(int PRIORITY, Command command) {

        this.PRIORITY = PRIORITY;
        this.command = command;
    }

        /**
         * Returns the command created with the scheduler request
         */
    public Command getCommand() {
        return command;
    }
    
        /**
         *  Returns the priority of the scheduler request
         */
    public int getPriority() {
        return PRIORITY;
    }

}