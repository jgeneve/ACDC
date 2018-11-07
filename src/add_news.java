import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Add_news {
	
	public static News news;
	public static final String yes = "YES";
	public static final String no = "NO";
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 

	public static void main(String[] args) {
		if (askParameters()) {
			String markdown = Markdown.toMarkdown(news);
			Markdown.createMarkdownFile(markdown, news);
			System.out.println("---");
			Tools.seeDemo();
		} else {
			System.out.println("Something went wrong whith the program, please restart the program");
		}
	}

	public static boolean askParameters() {
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
			
			//Demande si l'utilisateur veut choisir une category existante ou en creer une nouvelle
			String categoryAnswer = null;
			do {
				System.out.print("1-Use an existing category / 2-Create a new category: ");
				categoryAnswer = input.readLine();
			} while (!categoryAnswer.equals("1") && !categoryAnswer.equals("2"));
			//Utiliser une category existante
			String categories = null;
			if (categoryAnswer.equals("1")) {
				List<String> categoryList = Categories.getCategories();
				if (categoryList.size() > 0) { //Il y a deja des categories dans le fichier
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
					categories = categoryList.get(categoryNumber-1);
				} else { //Aucune categorie dans le fichier
					System.out.println("No categories created yet. Please create a new one");
					System.out.print("Category name: ");
					categories = input.readLine();
					Categories.addCategory(categories);
				}
			} else if (categoryAnswer.equals("2")) {
				System.out.print("Category name: ");
				categories = input.readLine();
				Categories.addCategory(categories);
			}

			System.out.println("---");

			//Demande si l'utilisateur veut ajouter une/des image(s)
			String imageAnswer = null;
			do {
				System.out.print("Do you want to add images ? (yes / no): ");
				imageAnswer = input.readLine();
			} while (!imageAnswer.toUpperCase().equals(yes) && !imageAnswer.toUpperCase().equals(no));
			//Demande le lien vers le/les images
			List<String> imageList = new ArrayList<>();
			if (imageAnswer.toUpperCase().equals(yes)) {
				System.out.print("Add the image(s) separate by a space: ");
				String imageInputList = input.readLine();
				String[] images = imageInputList.split(" ");
				imageList = Arrays.asList(images);
			}

			//Demande si l'utilisateur veut ajouter un/des lien(s)
			String linkAnswer = null;
			do {
				System.out.print("Do you want to add links ? (yes / no): ");
				linkAnswer = input.readLine();
			} while (!linkAnswer.toUpperCase().equals(yes) && !linkAnswer.toUpperCase().equals(no));
			//Demande le/les lien(s)
			List<String> linkList = new ArrayList<>();
			if (linkAnswer.toUpperCase().equals(yes)) {
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
			System.out.print("content: ");
			String content = input.readLine();

			//Si l'on arrive jusqu'a la fin sans erreur : tout c'est bien passe
			news = new News(layout, title, date, categories, author, content, linkList, imageList);
			return true;
			
		} catch (Exception e) {
			//Il y a eu une erreur : return false
			System.out.println(e);
			return false;	
		}
	}
	
	
}
