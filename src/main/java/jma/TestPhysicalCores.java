package jma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestPhysicalCores {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TestPhysicalCores.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Number of cores = {}", PhysicalCores.count());

	}

}
