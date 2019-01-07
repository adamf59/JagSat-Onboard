package adamf59.SystemHostController.IO;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogOutput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import adamf59.SystemHostController.SystemHost;

public class GPIO {

    private static GpioController GPIOController;

        /**
         * Initialize the GPIO Controller Object. This is a singleton!
         */
    public static int initGPIOController() {
        try {
            SystemHost.consolePrintln("OK", "Starting up GPIOController");
            GPIOController = GpioFactory.getInstance();
            
        } catch(UnsatisfiedLinkError e) {
            SystemHost.consolePrintln("ERR", "Failed to attach GPIOController.");

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
        SystemHost.consolePrintln("OK", "Shutting down GPIO Controller");
        GPIOController.shutdown();
    }

}