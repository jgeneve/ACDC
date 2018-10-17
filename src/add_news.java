import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class add_news {
	
	private static News news = new News();
	
	public static void main(String[] args) {
		if(askParameters()) {
			//news.generateMarkdown();
			//TODO generer le fichier markdown + ajouter commentaires
		}else {
			throw new Error("Something went wrong with the program, please try again");
		}
	}
	
	//Fonction qui demande les différents parametres de début et return true si tout c'est bien passé, sinon false
	public static boolean askParameters() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("---");
			
			System.out.print("layout: ");
			news.setLayout(scanner.nextLine());
			
			System.out.print("title: ");
			news.setTitle(scanner.nextLine());
			
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			System.out.println("date: "+ date);
			news.setDate(date);
			
			System.out.print("categories: ");
			news.setCategories(scanner.nextLine());
			
			System.out.println("---");
			
			System.out.print("author: ");
			news.setAuthor(scanner.nextLine());
			
			System.out.println("content: \n");
			news.setContent(scanner.nextLine());
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
