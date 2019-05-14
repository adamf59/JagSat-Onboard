/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;
import jssc.SerialPort;
import jssc.SerialPortException;

public class Communications extends Subsystem {

   public static SerialPort serialPort;


    public Communications(int id) {
        super("JAGSAT_COMMUNICATIONS_SUBSYSTEM", 1);
    }

    @Override
    public void init() {
        serialPort = new SerialPort("/dev/ttyUSB0"); 

        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_19200,    SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
            SerialPort.PARITY_NONE);
    serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            //Add an interface through which we will receive information about events
            serialPort.addEventListener(new CommunicationsReciever(), SerialPort.MASK_RXCHAR);
            serialPort.writeString("AT");

        }
        catch (SerialPortException ex) {
            Console.printErr("Failed to initialize Communications Subsystem. Reason:" + ex.getMessage());
        }



    }

    @Override
    public void execute() {
        Console.printOk("Communications subsystem updating...");
        try {
        Thread.sleep(3200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void executeAlways() {

    }


    
    protected void transmit(String data) throws IllegalStateException, IOException {
        Console.printInfo("Transmitting (TX): " + data);

        try {
            serialPort.writeString(data);
        } catch (SerialPortException e) {

            Console.printErr("Failed to Transmit Message. Reason:" + e.getMessage());
        }

      
        
    }
    

}