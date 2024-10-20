package jma;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;








public class TestDataDir {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TestDataDir.class);
	
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	
	private static PrintWriter out() throws IOException {
		final Path file = Path.of("./data/pgn",DATE_FORMAT.format(LocalDate.now())+".pgn");
		Files.createDirectories(file.getParent());
		final PrintWriter printer = new PrintWriter(Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND));
		if (Files.size(file)!=0) {
			printer.println();
			printer.println("===========");
			printer.println();
		}
		return printer;
	}
	
	public static void ecrirePgn() throws IOException {
		try (PrintWriter out=out()) {
			getStuffPgn().forEach(out::println);
			out.flush();
			
		}
	}
	
	private static List<String> getStuffPgn() {
		List<String> mbls = new ArrayList<>();
		mbls.add("Lénine");
		mbls.add("Staline");
		return(mbls);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		final Path file = Path.of("./data/pgn", DATE_FORMAT.format(LocalDate.now())+".pgn");
		LOGGER.info("Chemin absolu = {}", file.normalize().toAbsolutePath().toString());
		ecrirePgn();
		
		

	}

}
