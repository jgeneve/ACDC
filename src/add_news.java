import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class add_news {
	
	private static News news = new News();
        private static String imageAnswer;
        private static String imageInputList;
	
	public static void main(String[] args) {
		if(askParameters()) {
			//news.generateMarkdown();
			//TODO generer le fichier markdown + ajouter commentaires
		}else {
			throw new Error("Something went wrong with the program, please try again");
		}
	}
	
	//Fonction qui demande les diff�rents parametres de d�but et return true si tout c'est bien pass�, sinon false
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
                        
                        do {
                            System.out.print("Do you want to add images ? (yes/no) : ");
                            imageAnswer = scanner.nextLine();
                            System.out.print(imageAnswer);
                        } while(imageAnswer.toUpperCase() == "YES" || imageAnswer.toUpperCase() == "NO"); //TODO condition de sortie fausse
                        
                        if (imageAnswer.toUpperCase() == "yes") 
                        {
                            System.out.print("Add the image(s) separate by a space: ");
                            imageInputList = scanner.nextLine();
                            String[] images = imageInputList.split(" ");
                            news.setImageList(Arrays.asList(images));
                        }
			
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
