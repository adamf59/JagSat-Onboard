package adamf59.SystemHostController.System;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Console {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    //ok
    public static void printOk(String message) {
        System.out.println("[  " + ANSI_GREEN + "OK" + ANSI_RESET + "  ] " + message);
    }

    //error
    public static void printErr(String message) {
        System.out.println("[  " + ANSI_RED + "ERROR" + ANSI_RESET + "  ] " + message);
    }

    //warning
    public static void printWarn(String message) {
        System.out.println("[  " + ANSI_YELLOW + "WARN" + ANSI_RESET + "  ] " + message);
    }

    public static void printInfo(String message) {
        System.out.println("[   " +getTimeStamp() + "] " + message);

    }

    public static void printInfoNL(String message) {
        System.out.print(message);

    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("HH:mm:ss:SS").format(Calendar.getInstance().getTime());
    }
}