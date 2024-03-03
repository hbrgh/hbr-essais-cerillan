package cerillan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CerillanApp {
	
	public static String getTimeStampAAAAMMDD_HHmmssnow() {
		
	
		 LocalDateTime now = LocalDateTime.now();

	     

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH:mm:ss");

	        String formatDateAAAAMMddHHmmss = now.format(formatter).replaceAll(":","");
	        

	        
	        return(formatDateAAAAMMddHHmmss);
	}

	public static void main(String[] args) {
		
		String s= "2021-01-31";
		System.out.println(s.substring(0,4));
		
	double dd = 0.9999;
		
		System.out.println((int)dd);

		System.out.println(getTimeStampAAAAMMDD_HHmmssnow());

	}

}
