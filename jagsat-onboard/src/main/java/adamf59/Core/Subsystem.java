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
 * Subsystems contain code that should stay seperate from other components, to avoid
 * them crashing eachother if an error occurs. Subsystems contain their own behavior, and can interact with eachother.
 * Subsystems will begin executing immediately.
 * @author Adam Frank
 */
public abstract class Subsystem implements Runnable {

    private int id;
    private String name;
    private boolean subsystem_running = true;
    private boolean subsystem_master_loop = true;
    private Thread instanceThread;

        /**
         * Creates a new subsystem
         * @param name
         * @param id
         */
    public Subsystem(String name, int id) {
        this.id = id;
        this.name = name;
        init();
        instanceThread = new Thread(this, name);
        instanceThread.start();
    }

        /**
         * Called when the subsystem is created, but run before the subsystem starts
         */
    public abstract void init();

        /**
         * Called repeatedly while the subsystem isn't suspended
         */
    public abstract void execute();

        /**
         * Called repeatedly as long as the subsystem remains alive. It is stopped when the subsystem is destroyed
         */
    public abstract void executeAlways();

        /**
         * Stops the subsystem from executing (the execute method), but does not fully stop it.
         */
    public final void suspendSubsystem() {
        Console.printInfo("Suspending subsystem with name: " + name + " and id: " + id);
        subsystem_running = false;
    }
        /**
         * Resumes the subsystem after it was suspended
         */
    public final void resumeSubsystem() {
        Console.printInfo("Resuming subsystem with name: " + name + " and id: " + id);
        subsystem_running = true;
    }
        /**
         * Returns whether the subsystem is suspended or not
         * @return boolean
         */
    public boolean isSubsystemSuspended() {
        return subsystem_running;
    }
    
        /**
         * Immediately destroys the subsystem, without any clean up or additional actions.
         */
    @SuppressWarnings("deprecation")
    public final void destroySubsystem() {
        instanceThread.stop();
    }

        //TODO add way to peacefully close the subsystem

        /**
         * Returns whether the subsystem is alive or not
         * @return boolean
         */
    public boolean isSubsystemAlive() {
        return instanceThread.isAlive();
    }

        /**
         * Gets the id of the subsystem
         * @return subsystem id (int)
         */
    public final int getSubsystemId() {
        return id;
    }
        /**
         * Gets the name of the subsystem
         * @return subsystem name (String)
         */
    public final String getSubsystemName() {
        return name;
    }
    
    @Override
    public final void run() {
        while(subsystem_master_loop) {
            try {

                Thread.sleep(1); 
                executeAlways();

            if(subsystem_running) {
                
                execute();

                 }

			} catch (Exception e) {
                e.printStackTrace();
                Console.printErr("Exception thrown in subsystem: " + name + " with id: " + id + " >> " + e.getCause());
			}
        
        }
    
}
}