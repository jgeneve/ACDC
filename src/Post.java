import java.util.List;

public class Post {

	private String layout;
	private String title;
	private String date;
	private String category;
	private String author;
	private String content;
	private List<String> linkList;
	private List<String> imageList;

	public Post(String layout, String title, String date, String category, String author, String content,
			List<String> linkList, List<String> imageList) {
		this.layout = layout;
		this.title = title;
		this.date = date;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
}
