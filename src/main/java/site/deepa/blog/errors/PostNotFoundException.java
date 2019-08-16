package site.deepa.blog.errors;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such post")
public class PostNotFoundException extends RuntimeException {
	
	public PostNotFoundException(int id) {
		super("Post #" + id + " not found");
	}

}
