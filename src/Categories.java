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

	public static String chooseExistingCategory() throws IOException  {
		List<String> categoryList = getCategories();
		if (categoryList.size() > 0) {
			//Affiche toutes les categories du fichier
			for(int i = 0; i < categoryList.size(); i++) {
				System.out.println((i+1) + "-" + categoryList.get(i));
			}
			//L'utilisateur doit choisir sa categorie
			int categoryNumber = -1;
			do {
				System.out.print("Choose your category: ");
				categoryNumber = Integer.parseInt(input.readLine());
			} while (categoryNumber < 1 || categoryNumber >categoryList.size());
			return categoryList.get(categoryNumber-1);
		} else {
			System.out.println("No categories created yet. Please create a new one");
			return createCategory();
		}
	}
	
	public static String createCategory() throws IOException {
		System.out.print("Category name: ");
		String category = input.readLine();
		
		//Open categoies.txt file
		String filename = "categories.txt";
		File file = new File("web-master" + File.separator + "BLOG" + File.separator + "category" + File.separator + filename);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(), true));
		writer.append(category.toLowerCase());
		writer.newLine();
		writer.close();
		
		return category;
	}
	
	public static List<String> getCategories() throws IOException {
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
	}
	
}
