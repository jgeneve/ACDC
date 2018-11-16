import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

	public static Git git;


	public static void main(String[] args) {
		try {

			// CONFIG REPERTOIRE LOCAL ET DISTANT
			//TODO Créer une méthode Git pour set les répertoires
			git = new Git();
			git.setLocalRepo("C:\\Users\\jgeneve\\Documents\\IMTA1\\web-master\\BLOG");
			git.setGithubRepo("https://github.com/jgeneve/web_inria.git");

			Post post = askPostInformationCmd();

			Categories.addCategory(post.getCategory());

			String markdown = Markdown.toMarkdown(post);
			Markdown.createMarkdownFile(markdown, post);

			Tools.demo();
			
			System.out.println("--- Done ---");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static Post askPostInformationCmd() {
		String layout = "post";
		System.out.println("Layout: " + layout);

		System.out.print("Title: ");
		String title = Tools.getStringUserInput();

		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Date: "+ date);

		System.out.print("Category: ");
		String category = Tools.getStringUserInput();

		System.out.print("Link to the image(s) (Split by a space if multiple "
				+ " or leave it blank): ");
		String imagesInputString = Tools.getStringUserInput();
		String[] images = imagesInputString.split(" ");
		List<String> imageList = Arrays.asList(images);

		System.out.print("External links (Split by a space if multiple "
				+ " or leave it blank): ");
		String linksInputString = Tools.getStringUserInput();
		String[] links = linksInputString.split(" ");
		List<String> linkList = Arrays.asList(links);

		System.out.print("Author name: ");
		String author = Tools.getStringUserInput();

		System.out.print("Content: ");
		String content = Tools.getStringUserInput();

		return new Post(layout, title, date, category, author, content, linkList, imageList);
	}
}
