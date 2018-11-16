import java.io.File;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Markdown {

	public static String toMarkdown(Post post) {
		StringBuilder sb = new StringBuilder();

		createMarkdownStructure(sb, post);
		addImagesToMarkdown(sb, post);
		addLinksToMarkdown(post, sb);
		
		return sb.toString();
	}

	private static void addLinksToMarkdown(Post post, StringBuilder sb) {
		if (!post.getLinkList().isEmpty()) {
			for (String link : post.getLinkList()) {
				if (link.length() > 0) {
					sb.append("\n[" + link + "](" + link + ")");
				}
			}		
		}
	}

	private static void addImagesToMarkdown(StringBuilder sb, Post post) {
		if (!post.getImageList().isEmpty()) {
			for (String image : post.getImageList()) {
				if (image.length() > 0) {
					sb.append("\n![" + image + "](" + image + ")");
				}
			}			
		}
	}

	private static void createMarkdownStructure(StringBuilder sb, Post post) {
		sb.append("---"
				+ "\nlayout: " + post.getLayout()
				+ "\ntitle: \"" + post.getTitle()+ "\""
				+ "\ndate: " + post.getDate()
				+ "\ncategories: " + post.getCategory()
				+ "\n---"
				+ "\n\n*By " + post.getAuthor() + "*"
				+ "\n\n" + post.getContent()
				+ "\n"
				);
	}
	
	public static File createMarkdownFile(String markdownString, Post post) {	
		String filename = post.getDate()+ "-" + post.getTitle().replaceAll(" ", "-") + ".markdown"; 
		File file = new File(Main.git.getLocalRepo() + File.separator + "_posts" + File.separator + filename);
		try {
			file.createNewFile();
			Writer writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8);
			writer.write(markdownString);
			writer.close();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
