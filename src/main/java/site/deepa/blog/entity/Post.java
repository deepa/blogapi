package site.deepa.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Post {
	
	public Post() {}
	
	@Id @Column(name="id")
	private int PostId;
	
	@NotEmpty(message = "Please provide a blog title")
	private String title;
	
	@NotEmpty(message = "Please provide a blog entry")
	private String body;
	
	public Post(int postId, String title, String body) {
		super();
		PostId = postId;
		this.title = title;
		this.body = body;
	}
	public int getPostId() {
		return PostId;
	}
	public void setPostId(int postId) {
		PostId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Post [PostId=" + PostId + ", title=" + title + ", body=" + body + "]";
	}
}
