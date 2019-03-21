/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.IO;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class GPIO {

    private static GpioController GPIOController;

        /**
         * Initialize the GPIO Controller Object. This is a singleton!
         */
    public static int initGPIOController() {
        try {
            Console.printOk("Starting up GPIOController");
            GPIOController = GpioFactory.getInstance();
            
        } catch(UnsatisfiedLinkError e) {
            Console.printErr("Failed to attach GPIOController.");

                return 0;
        }
            return 1;
    }
        /**
         * Gets the current singleton instance of the GPIOController
         * @return GPIOController
         */
    public static GpioController getGPIOController() {
            return GPIOController;
    }
        /**
         * Shuts down the GPIOController.
         */
    public static void shutdown() {
        Console.printOk("Shutting down GPIO Controller");
        GPIOController.shutdown();
    }

}