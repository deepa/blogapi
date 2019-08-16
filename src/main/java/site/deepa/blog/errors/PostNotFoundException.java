package site.deepa.blog.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such post")
public class PostNotFoundException extends RuntimeException {
	
	public PostNotFoundException(int id) {
		super("Post #" + id + " not found");
	}

}
