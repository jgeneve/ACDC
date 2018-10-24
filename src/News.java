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
        
	
	public String generateMarkdown() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"---"
				+"\n### " + this.getTitle()
				+ "\n"+this.date
				+"\n"+this.categories
                +"\n---"
				+"\n*"+this.getAuthor()+"*"
				+"\n"+this.getContent()
				);
		System.out.println(sb.toString());
		return sb.toString();
	}
	
}
