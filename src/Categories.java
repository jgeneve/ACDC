import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Categories {

	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static File file = new File(Main.git.getLocalRepo() + File.separator + "category" + File.separator + "categories.txt");

	public static void addCategory(String category) {
		try {	
			List<String> categoriesList = getCategories();
			if (!categoriesList.contains(category.toLowerCase())) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true));
				writer.append(category.toLowerCase());
				writer.newLine();
				writer.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getCategories() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			List<String> categoryList = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				categoryList.add(line);
			}
			reader.close();
			return categoryList;
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void removeCategory(String category) {
		try {
			List<String> out = Files.lines(file.toPath())
					.filter(line -> !line.contains(category))
					.collect(Collectors.toList());
			Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
