import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class add_news {
	
	public static News news;

	public static void main(String[] args) throws IOException {
		if (askParameters()) {
			news.generateMarkdown();
		} else {
			System.out.println("Something went wrong whith the program, please restart the program");
		}
	}

	public static boolean askParameters() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 

		try {
			System.out.println("---");

			//Demande le layout
			String layout = "post";
			System.out.println("layout: " + layout);

			//Demande le titre
			System.out.print("title: ");
			String title = input.readLine();

			//Remplie le champs date avec la date du jour
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			System.out.println("date: "+ date);

			//Demande la categorie
			System.out.print("categories: ");
			String categories = input.readLine();

			System.out.println("---");

			//Demande si l'utilisateur veut ajouter une/des image(s)
			int imageAnswer = 0;
			do {
				System.out.println("Do you want to add images ? \n1-yes \n2-no");
				imageAnswer = Integer.parseInt(input.readLine());
			} while (imageAnswer != 1 && imageAnswer != 2);
			//Demande le lien vers le/les images
			List<String> imageList = new ArrayList<>();
			if (imageAnswer == 1) {
				System.out.print("Add the image(s) separate by a space: ");
				String imageInputList = input.readLine();
				String[] images = imageInputList.split(" ");
				imageList = Arrays.asList(images);
			}

			//Demande si l'utilisateur veut ajouter un/des lien(s)
			int linkAnswer = 0;
			do {
				System.out.println("Do you want to add links ? \n1-yes \n2-no");
				linkAnswer = Integer.parseInt(input.readLine());
			} while (linkAnswer != 1 && linkAnswer != 2);
			//Demande le/les lien(s)
			List<String> linkList = new ArrayList<>();
			if (linkAnswer == 1) {
				System.out.print("Add the link(s) separate by a space: ");
				String linkInputList = input.readLine();
				String[] links = linkInputList.split(" ");
				linkList = Arrays.asList(links);
			}

			System.out.println("---");

			//Demande l'auteur
			System.out.print("author: ");
			String author = input.readLine();

			//Demande le contenu
			System.out.println("content: \n");
			String content = input.readLine();

			//Si l'on arrive jusqu'a la fin sans erreur : tout c'est bien passe
			news = new News(layout, title, date, categories, author, content, linkList, imageList);
			return true;
			
		} catch (Exception e) {
			//Il y a eu une erreur : return false
			return false;	
		}
	}

}
