package site.deepa.blog.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import site.deepa.blog.entity.Post;
import site.deepa.blog.errors.PostNotFoundException;
import site.deepa.blog.errors.UnsupportedPatchFieldException;
import site.deepa.blog.repository.PostRepository;

@Service
public class PostsService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> getPosts() {
		List<Post> list = new ArrayList<>();
		for(Post post: repo.findAll()) {
			list.add(post);
		}
		return list;
	}

	public Post getPost(int id) {
		return repo.findById(id).orElseThrow(() -> new PostNotFoundException(id)); 
	}

	public void addPost(Post post) {
		repo.save(post);
	}

	public void updatePost(Post post, int id) {
		repo.findById(id).map(x -> {
			x.setBody(post.getBody());
			x.setTitle(post.getTitle());
			return repo.save(x);
		})
		.orElseGet(() -> {
			post.setPostId(id);
			return repo.save(post);
		});
	}

	public void deletePost(int id) {
		repo.deleteById(id);
	}

	public void patchPost(Map<String, String> post, int id) {
		repo.findById(id).map(x -> {
			String body = post.get("body");
			if (!StringUtils.isEmpty(body)) {
				x.setTitle(body);
				return repo.save(x);
			} else {
				throw new UnsupportedPatchFieldException(post.keySet());
			}
		})
		.orElseGet(() -> {
			throw new PostNotFoundException(id);
		});
	}
}
