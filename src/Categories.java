import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Categories {
	
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void addCategory(String category) {
		try {
			//Open categoies.txt file
			String filename = "categories.txt";
			File file = new File("web-master" + File.separator + "BLOG" + File.separator + "category" + File.separator + filename);
	
			List<String> categoriesList = getCategories();
			if (!categoriesList.contains(category.toLowerCase())) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true));
				writer.append(category.toLowerCase());
				writer.newLine();
				writer.close();
			}
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public static List<String> getCategories() {
		try {
			String filename = "categories.txt";
			File file = new File("web-master" + File.separator + "BLOG" + File.separator + "category" + File.separator + filename);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			List<String> categoryList = new ArrayList<>();
			while((line = reader.readLine()) != null) {
				categoryList.add(line);
			}
			reader.close();
			return categoryList;
		} catch(IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
}
