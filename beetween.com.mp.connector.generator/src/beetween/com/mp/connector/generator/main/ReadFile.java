package beetween.com.mp.connector.generator.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
	
	public static String readFromFile(String pahtFile)
			  throws IOException {
		
	    Path path = Paths.get(pahtFile);
	    return Files.readString(path);
	}

}
