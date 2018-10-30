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

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<String> linkList) {
		this.linkList = linkList;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "News [layout=" + layout + ", title=" + title + ", date=" + date + ", categories=" + categories
				+ ", author=" + author + ", content=" + content + ", linkList=" + linkList + ", imageList=" + imageList
				+ "]";
	}



}
