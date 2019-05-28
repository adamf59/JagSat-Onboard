/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Communications;

import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.System.Console;

public class TransmissionFactory {

    /**
     * Formats an array of flight data into transmission format
     */
    public static String packageData(String[] data) {
        String outputString = "";

            for(int i = 0; i < 12; i++) {
                if(i == 11) {
                    outputString += data[i];

                } else {
                    outputString += data[i] + "/";

                }
            }        
            return outputString;
    }

    /**
     * Takes a recieved data packet and turns it into the core request data.
     */
    public static String[] unpackageData() {
        
        return null;

    }

    /**
     * Runs the sequence for transmitting a data point
     * <br>
     * 1. update all the flight data
     * <br>
     * 2. package the data for transmission
     * <br>
     * 3. ensure data is within length for transmission (50 chars or less)
     * <br>
     * 4. transmit data
     */
    public static void sequenceTransmission() {
        Console.printInfo("==Transmission Auto-Sequence Start==");
        try {
            //SystemHost.getBME280().pushUpdate();

            String barometer_pressure = "AAAAAAAA";
            String remaining_ballast = "BBBB";
            String avionics_temp = "CCCC";
            String external_temp = "DDDD";
            String humidity = "EEEE";
            String bat_voltage = "FFF";
            String bat_capacity = "GGG";
            String drop_incentive = "HHH";
            String autopilot_status = "I";
            String system_health = "JJ";
            String power_mode_state = "K";
            String system_crashed = "L";

    String outbound_packet = packageData(
        new String[]{barometer_pressure,remaining_ballast,
        avionics_temp,external_temp,humidity,bat_voltage,bat_capacity,drop_incentive,autopilot_status,
        system_health,power_mode_state,system_crashed
    });

    //check the length to ensure it is under 50 characters.

    if(outbound_packet.length() <= 50) {

        //proceed!
        System.out.println("packet: " + outbound_packet);

    } else {
        System.out.println("Packet length out of bounds! length=" + outbound_packet.length());

    }






        } catch(Exception e) {
            Console.printErr("Failed to sequence a new transmission. Reason: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        sequenceTransmission();
        
    }

}