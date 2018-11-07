import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Markdown {

	public static String toMarkdown(News news) {
		StringBuilder sb = new StringBuilder();

		sb.append("---"
				+ "\nlayout: " + news.getLayout()
				+ "\ntitle: \"" + news.getTitle()+ "\""
				+ "\ndate: " + news.getDate()
				+ "\ncategories: " + news.getCategories()
				+ "\n---"
				+ "\n\n*By " + news.getAuthor() + "*"
				+ "\n\n" + news.getContent()
				+ "\n"
				);

		//Add images in the markdown
		for (String image : news.getImageList()) {
			sb.append("\n![" + image + "](" + image + ")");
		}

		//Add links in the markdown
		for (String link : news.getLinkList()) {
			sb.append("\n[" + link + "](" + link + ")");
		}
		return sb.toString();
	}
	
	public static File createMarkdownFile(String markdownString, News news) {	
		String filename = news.getDate()+ "-" + news.getTitle().replaceAll(" ", "-") + ".markdown"; 
		File file = new File("web-master" + File.separator + "BLOG" + File.separator + "_posts" + File.separator + filename);
		try {
			file.createNewFile();
			Writer writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8);
			writer.write(markdownString);
			writer.close();
			return file;
		} catch (Exception e) {
			System.out.println("Error: file cannot be created");
			return null;
		}
	}
	
}
