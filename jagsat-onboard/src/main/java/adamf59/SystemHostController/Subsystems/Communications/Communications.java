/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;
import java.util.Date;

import com.pi4j.io.gpio.exception.UnsupportedBoardType;
import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPort;
import com.pi4j.io.serial.SerialPortException;
import com.pi4j.io.serial.StopBits;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class Communications extends Subsystem {


    /**
     * How often to transmit a packet with a data point
     */
    private static int TRANSMIT_INTERVAL = 300000; 

    public static SerialConfig config = new SerialConfig();
    public static final Serial serial = SerialFactory.createInstance();

    private String last_response = "";

    /**
     * Creates a new instance of the Communications Subsystem
     */
    public Communications(int id) {
        super("JAGSAT_COMMUNICATIONS_SUBSYSTEM", 1);
    }

    @Override
    public void init() {

        

        try {

            serial.addListener(new SerialDataEventListener() {
                @Override
                public void dataReceived(SerialDataEvent event) {
    
                    // NOTE! - It is extremely important to read the data received from the
                    // serial port.  If it does not get read from the receive buffer, the
                    // buffer will continue to grow and consume memory.
    
                    // print out the data received to the console
                    try {
                        Console.printInfo("Communications Recieved (RX)");
                            last_response = event.getAsciiString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });








            config.device(SerialPort.getDefaultPort()).baud(Baud._19200).dataBits(DataBits._8).parity(Parity.NONE)
                    .stopBits(StopBits._1).flowControl(FlowControl.NONE);
                    serial.open(config);







        } catch (UnsupportedBoardType | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void execute() {
        Console.printOk("Communications subsystem updating...");
        try {
        Thread.sleep(TRANSMIT_INTERVAL);
        
        
        

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void executeAlways() {

    }


        /**
         * Transmits the data across the serial bus to the connected device.
         */
    protected void transmit(String data) throws IllegalStateException, IOException {
        Console.printInfo("Transmitting (TX): " + data);

        try {
            serial.write(data + "\r");

        } catch (SerialPortException e) {

            Console.printErr("Failed to Transmit Message. Reason:" + e.getMessage());
        }

      
        
    }
        /**
         * Returns the last message recieved from the serial bus
         * @return String
         */
    public String getLastResponse() {
        return last_response;
    }
    

}