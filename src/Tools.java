import java.io.IOException;

public class Tools {

	public static void executeCommand(String command) {
		Runtime rt = Runtime.getRuntime();
		try {
			Process pr = rt.exec(command);
		} catch (IOException e) {
			System.out.println("Error: the command " + command + "cannot be execute.");
		} 			
	}
	
	public static void pushGit() {
		
	}
	
}
