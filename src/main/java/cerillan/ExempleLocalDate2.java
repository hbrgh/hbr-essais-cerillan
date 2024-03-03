package cerillan;


import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.ResolverStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;


public class ExempleLocalDate2 {
	
	private static final int NB_CHARS_YEAR = 4; // yyyy
	private static final int NB_CHARS_MONTH = 2; // MM
	private static final int NB_CHARS_MONTHYEAR = NB_CHARS_YEAR + NB_CHARS_MONTH;
	
	
    
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

	private static int getNumberOfDaysInMonth(String yearMonthYYYYMM) throws DateTimeException {
		String annee = yearMonthYYYYMM.substring(0, NB_CHARS_YEAR);
		String mois = yearMonthYYYYMM.substring(NB_CHARS_YEAR, NB_CHARS_MONTHYEAR);
		
		int year = Integer.parseInt(annee);
		int month = Integer.parseInt(mois);

		YearMonth yearMonthObject;
		
		yearMonthObject = YearMonth.of(year, month);
		 
		int nbDays = yearMonthObject.lengthOfMonth();
		return(nbDays);
	}
	
	private static void createLocDate(LocalDate pLocalDate) {
		
		pLocalDate =  LocalDate.of(2020, 6, 26);
		
	}
   public static void main(String[] args) {
//	//default time zone
//	ZoneId defaultZoneId = ZoneId.systemDefault();
//		
//	//creating the instance of LocalDate using the day, month, year info
//        LocalDate localDate = LocalDate.of(2016, 8, 19);
//        
//        //local date + atStartOfDay() + default time zone + toInstant() = Date
//        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).plusHours(12L).toInstant());
//        
//        //Displaying LocalDate and Date
//        System.out.println("LocalDate is: " + localDate);
//        System.out.println("Date is: " + date);
//        
//        localDate = LocalDate.of(2020, 12, 23);
//       
//        System.out.println(localDate + " ==> "+localDate.getDayOfYear());
//        
//        localDate = LocalDate.of(2020, 12, 31);
//        
//        System.out.println(localDate + " ==> "+localDate.getDayOfYear());
//        
//        LocalDate lDatttttttt = LocalDate.of(2020, 12, 31);;
//        
//        createLocDate(lDatttttttt);
//        System.out.println("LocalDate lDatttttttt is: " + lDatttttttt);
//        
//        String dateeee = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        System.out.println("dateeee is: " + dateeee);
//        
//        Date dateIndus = Date.from(localDate.atStartOfDay(defaultZoneId).plusHours((long)6).toInstant());
//        System.out.println("dateIndus is: " + dateIndus);
//        
//       
////        Locale bLocale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
////        String dateEx = "28/02/2021";
////
////        LocalDate localDateExx = LocalDate.parse(dateEx, formatter);
////        System.out.println("LocalDate localDateEx is: " + localDateExx);
//        
//        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        System.out.println(LocalDate.from(europeanDateFormatter.parse("15.08.2014")).isLeapYear());
//        
////        DateTimeFormatter europeanDateFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////        System.out.println(LocalDate.from(formatter.parse("15/08/2014")).isLeapYear());
//        
//        DateTimeFormatter dtf =  DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
//        String currentFormattedDate = dtf.format(LocalDate.now());
//        System.out.println(currentFormattedDate);
//        
//        LocalDate localDateEx = LocalDate.parse( 
//        	       "29/02/2016" ,  
//        	       DateTimeFormatter.ofPattern( "dd/MM/uuuu"  , Locale.FRANCE).withResolverStyle(ResolverStyle.STRICT)
//        	);
//        System.out.println("LocalDate localDateEx is: " + localDateEx);
//      
//        
////        LocalDate localDateExxxxx = LocalDate.parse( 
////     	       "2hh" ,  
////     	       DateTimeFormatter.ofPattern( "dd/MM/uuuu"  , Locale.FRANCE).withResolverStyle(ResolverStyle.STRICT)
////     	);
////     System.out.println("LocalDate localDateEx is: " + localDateExxxxx);
//        
//        LocalDate lt   = LocalDate.now(); 
//        LocalDate nextMondayLocalDate = lt.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//
//    // print result 
//    System.out.println("nextMondayLocalDate : "
//                       + nextMondayLocalDate); 
//    System.out.println("LocalDate localDateEx is: " + europeanDateFormatter.format(localDateEx));
//    DateTimeFormatter europeanDateFormatterSlashes = DateTimeFormatter.ofPattern( "dd/MM/uuuu"  , Locale.FRANCE).withResolverStyle(ResolverStyle.STRICT);
//    System.out.println("LocalDate localDateEx is: " + europeanDateFormatterSlashes.format(localDateEx));
//    
//    String yyyymm1 = "202101";
//    System.out.println("number of days of "+ yyyymm1 + ": "+ getNumberOfDaysInMonth(yyyymm1));
//    String yyyymm2 = "202102";
//    System.out.println("number of days of "+ yyyymm2 + ": "+ getNumberOfDaysInMonth(yyyymm2));
//    String yyyymm3 = "202111";
//    System.out.println("number of days of "+ yyyymm3 + ": "+ getNumberOfDaysInMonth(yyyymm3));
//    
   }
}