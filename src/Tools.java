import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.awt.Desktop;
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
			System.out.println(e);
			System.out.println("Error: the command " + command + "cannot be execute.");
		} 			
	}
	
	public static void pushGit() {
		
	}

	public static void seeDemo()  {
		try {
			Thread thread = new Thread();
			thread.start();
			Tools.executeCommand("bundle exec jekyll build web-master/BLOG/");
			Tools.executeCommand("bundle exec jekyll serve -o web-master/BLOG/");
			// URI website = new URI("http://127.0.0.1:4000/blog/");
			// Desktop.getDesktop().browse(website);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
