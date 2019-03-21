/**
 * [[[JAGSAT CORE]]]
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.Core;

import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

/**
     * Commands are specific actions to do, their execute methods run once, or can be looped within using reiterate.
     * The run in their own thread to prevent total crashes if the command fails or throws an exception.
     * @author Adam Frank
     */
public abstract class Command implements Runnable {

        private String command_name = "";
        private Thread instanceThread;

         /**
         * Creates a new command
         */
    public Command(String command_name) {
        this.command_name = command_name;
        instanceThread = new Thread(this, "JAGSAT_DPC_" + command_name);
    }
        /**
         * The init method is ran once when the method is started, before the primary execute() method is started.
         *  It will not run if the reiterate() method is called.
         */
    public abstract void init();

        /**
         * The execute method is called when the command is created. It can also be called if the reiterate
         * method is called.
         */
    public abstract void execute();

        /**
         * startThread is used to start the command instance thread
         */
    public final void startThread() {
        instanceThread.start();
    }
        /**
         * Gets the name of the command
         * @return String (command name)
         */
    public final String getCommandName() {
        return command_name;
    }

    @Override
    public final void run() {
        execute();
    }    
        /**
         * The sleep method will sleep this command apart from all other threads, namely the
         * DispatcherThread.
         * @param millis
         * @throws InterruptedException
         */
    @SuppressWarnings("static-access")
    public final void sleep(int millis)  {
        try {
            instanceThread.sleep(millis);
        } catch(Exception e) {
            Console.printErr("Exception thrown when command (" + command_name + ") tried to sleep <" + e.getMessage() + ">");
        }
    }
        /**
         * Used to reloop the execute method, likely within the execute method itself to create recursion.
         */
    public final void reiterate() {
            execute();
    }
    
}