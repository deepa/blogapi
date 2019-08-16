package site.deepa.blog.errors;

import java.util.Set;

public class UnsupportedPatchFieldException extends RuntimeException {
	public UnsupportedPatchFieldException(Set<String> keys) {
		super("Field " + keys.toString() + " update is not allowed");
	}
}
