package cerillan;

public class TestOnBinary {
	
	public static void printLongAsBinary(long l) {
		for(int i = 0; i < Long.numberOfLeadingZeros((long)l); i++) {
		      System.out.print('0');
		}
		System.out.println(Long.toBinaryString((long)l));
	}

	public static void main(String[] args) {
		
		printLongAsBinary(256L);
		printLongAsBinary(1L);
		printLongAsBinary(1099511627776L);
		printLongAsBinary(512L);
		

	}

}
