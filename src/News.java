import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class News {

	private String layout;
	private String title;
	private String date;
	private String categories;
	private String author;
	private String content;
	private List<String> linkList;
	private List<String> imageList;

	public News(String layout, String title, String date, String categories, String author, String content,
			List<String> linkList, List<String> imageList) {
		this.layout = layout;
		this.title = title;
		this.date = date;
		this.categories = categories;
		this.author = author;
		this.content = content;
		this.linkList = linkList;
		this.imageList = imageList;
	}

	public String generateMarkdown() {
		StringBuilder sb = new StringBuilder();

		sb.append("---"
				+ "\nlayout: " + this.layout
				+ "\ntitle: \"" + this.title + "\""
				+ "\ndate: " + this.date
				+ "\ncategories: " + this.categories
				+ "\n---"
				+ "\n\n*By " + this.author + "*"
				+ "\n\n" + this.content
				+ "\n"
				);

		//Add images in the markdown
		for (String image : imageList) {
			sb.append("\n![" + image + "](" + image + ")");
		}

		//Add links in the markdown
		for (String link : linkList) {
			sb.append("\n[" + link + "](" + link + ")");
		}

		return sb.toString();
	}
	
	public File createMarkdownFile(String markdownString) {	
		String filename = this.date + "-" + this.title.replaceAll(" ", "-") + ".markdown"; 
		File file = new File(".." + File.separator +"web-master" + File.separator + "BLOG" + File.separator + "_posts" + File.separator + filename);
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

	@Override
	public String toString() {
		return "News [layout=" + layout + ", title=" + title + ", date=" + date + ", categories=" + categories
				+ ", author=" + author + ", content=" + content + ", linkList=" + linkList + ", imageList=" + imageList
				+ "]";
	}



}
