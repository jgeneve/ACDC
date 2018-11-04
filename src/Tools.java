import java.io.IOException;
import java.io.InputStream;
import java.io.File;

public class Tools {

	public static void executeCommand(String command) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process pr = rt.exec(command, null, new File("web-master/BLOG"));
			InputStream in = pr.getInputStream();
			int c;
			while ((c = in.read()) != -1) {
			System.out.print((char) c);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error: the command " + command + "cannot be execute.");
		} 			
	}
	
	public static void pushGit() {
		
	}
	
}
