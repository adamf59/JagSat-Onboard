/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Communications;

import java.io.IOException;

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
import com.pi4j.io.serial.StopBits;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class Communications extends Subsystem {

    Serial rockblockSerial;
    SerialConfig serialConfig;

    public Communications(int id) {
        super("JAGSAT_COMMUNICATIONS_SUBSYSTEM", 1);
    }

    @Override
    public void init() {
        Console.printOk("Initializing Communications Subsystem");
        //rockblockSerial = SerialFactory.createInstance();
       // setupReciever();
       // serialConfig = new SerialConfig();
        try {
         //   serialConfig.device(SerialPort.getDefaultPort()).baud(Baud._38400).dataBits(DataBits._8).parity(Parity.NONE)
           //         .stopBits(StopBits._1).flowControl(FlowControl.NONE);
             ///       rockblockSerial.open(serialConfig);

        } catch (Exception e) {
            Console.printErr("Communications Subsystem Init Failed. Continuing anyway... ");

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


    private void setupReciever() {

        rockblockSerial.addListener(new SerialDataEventListener(){
        
            @Override
            public void dataReceived(SerialDataEvent event) {
                try {
                    Console.printInfo("Recieve: Communications RX: [HEX DATA]   " + event.getHexByteString());
                    Console.printInfo("Recieve: Communications RX: [ASCII DATA] " + event.getAsciiString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        
    
    }
    
    protected void transmit(String data) throws IllegalStateException, IOException {
        rockblockSerial.write(data);
    }
    

}