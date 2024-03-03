package cerillan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
public class Test {
	
	/**
     * Attempts to parse a string to a long. If it fails, returns the default
     *
     * @param s
     *            The string to parse
     * @param defaultLong
     *            The value to return if parsing fails
     * @return The parsed long, or the default if parsing failed
     */
    public static long parseLongOrDefault(String s, long defaultLong) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
           
            return defaultLong;
        }
    }
    public static LocalDate convertToLocalDateViaMillisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
    
    public static LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
          .atZone(ZoneId.systemDefault())
          .toLocalDateTime();
    }
 
/**
* @param args
*/
public static void main(String[] args) throws Exception{
   
	System.out.println(LocalDate.now());
	String bootTimeStrStrr = ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime");
	String[] a = bootTimeStrStrr.split(",");
	String bootTimeStrSec = ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", "");
	String bootTimeStrUsec = ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[1].split("}")[0].replaceAll("\\D", "");	         
	long bootTimeSecondes = parseLongOrDefault(bootTimeStrSec, System.currentTimeMillis() / 1000);
	long bootTimeComplMicrosecondes = parseLongOrDefault(bootTimeStrUsec, 0);
	long booTimeInMillis = (bootTimeSecondes * 1000) + (bootTimeComplMicrosecondes / 1000);

	LocalDate locDatt = convertToLocalDateViaMillisecond(new Date(booTimeInMillis));
	LocalDateTime locDattTime = convertToLocalDateTimeViaMilisecond(new Date(booTimeInMillis));
	System.out.println(locDatt);
	System.out.println(locDattTime);
           
  
}

}