import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Class of the program
 * @author Jordan GENEVE
 * @version 1.0
 * @since 1.0
 * 
 */
public class Main {

	public static String localRepo;
	public static String gitRepo;


	public static void main(String[] args) {
		localRepo = "C:\\Users\\jgeneve\\Documents\\IMTA1\\web-master\\BLOG";
		gitRepo = "https://github.com/jgeneve/web_inria.git";

		Post post = askPostInformationCmd();

		Categories.addCategory(post.getCategory());

		String markdown = Markdown.toMarkdown(post);
		Markdown.createMarkdownFile(markdown, post);

		System.out.println("\nStarting server, please wait. Your browser will be launch automatically.");
		Tools.executeCommand("bundle exec jekyll serve -o", localRepo, true);
		
		System.out.println("Commiting and pushing git. Wait a moment ...");
		Tools.gitCommitAndPush(gitRepo, localRepo);
		
		System.out.println("Jobs finished. You can close the program.");
	}

	/**
	 * Method that ask the data for the post
	 * @return Post - Object that contains the post data
	 */
	public static Post askPostInformationCmd() {
		String layout = "post";
		System.out.println("Layout: " + layout);
		
		System.out.print("Title: ");
		String title = Tools.getStringUserInput();
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("Date: "+ date);
		
		System.out.print("Category: ");
		String category = Tools.getStringUserInput();
		
		System.out.print("Link to the image(s) (Split by a space if multiple or leave it blank): ");
		String imagesInputString = Tools.getStringUserInput();
		String[] images = imagesInputString.split(" ");
		List<String> imageList = Arrays.asList(images);
		
		System.out.print("External links (Split by a space if multiple or leave it blank): ");
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
