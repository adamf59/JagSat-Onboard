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
        serialPort = new SerialPort("USB0"); 

        try {
            serialPort.openPort();
            serialPort.setParams(19200, 8, 1, 0);
            //Preparing a mask. In a mask, we need to specify the types of events that we want to track.
            //Well, for example, we need to know what came some data, thus in the mask must have the
            //following value: MASK_RXCHAR. If we, for example, still need to know about changes in states 
            //of lines CTS and DSR, the mask has to look like this: SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR
            int mask = SerialPort.MASK_RXCHAR;
            //Set the prepared mask
            serialPort.setEventsMask(mask);
            //Add an interface through which we will receive information about events
            serialPort.addEventListener(new CommunicationsReciever());
            serialPort.writeString("AT");

        }
        catch (SerialPortException ex) {
            System.out.println(ex);
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
            serialPort.writeString(data + "\r");
        } catch (SerialPortException e) {

            Console.printErr("Failed to Transmit Message. Reason:" + e.getMessage());
        }

      
        
    }
    

}