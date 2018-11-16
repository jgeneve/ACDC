import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.File;

public class Tools {

	public static String getStringUserInput() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String userInput = null;
		try {
			userInput = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}	

	private static class StreamGobbler implements Runnable {
		private java.io.InputStream inputStream;
		private java.util.function.Consumer<String> consumer;

		public StreamGobbler(java.io.InputStream inputStream, java.util.function.Consumer<String> consumer) {
			this.inputStream = inputStream;
			this.consumer = consumer;
		}

		@Override
		public void run() {
			new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).lines()
			.forEach(consumer);
		}
	}

	public static void demo() throws InterruptedException {
		final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			if (isWindows) {
				builder.command("cmd.exe", "/c", "bundle exec jekyll serve -o");
			} else {
				builder.command("sh", "-c", "bundle exec jekyll serve -o");
			}
			builder.directory(new File(Main.git.getLocalRepo()));
			Process process = builder.start();
			StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
			Executors.newSingleThreadExecutor().submit(streamGobbler);
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Press enter to stop demo");
			System.in.read();
			System.out.println("Demo killed");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
