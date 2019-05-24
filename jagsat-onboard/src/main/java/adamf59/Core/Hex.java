/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*
*  Build: 5.22.19a
*/
package adamf59.Core;

// See this post: https://www.baeldung.com/java-convert-hex-to-ascii

public class Hex {


    public static String asciiToHex(String asciiStr) {
        char[] chars = asciiStr.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString((int) ch));
        }
     
        return hex.toString();
    }

    public static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder("");
         
        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
         
        return output.toString();
    }


}