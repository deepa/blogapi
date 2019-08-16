package site.deepa.blog.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import site.deepa.blog.entity.Post;
import site.deepa.blog.services.PostsService;

@RestController
@Validated
public class PostsController {
	
	@Autowired
	private PostsService service;
	
	@RequestMapping("/posts")
	public List<Post> getPosts() {
		return service.getPosts();
	}
	
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable int id) {
		return service.getPost(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/posts")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addPost(@Valid @RequestBody Post post) {
		service.addPost(post);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/posts/{id}")
	public void updatePost(@RequestBody Post post, @PathVariable @Min(1) int id) {
		service.updatePost(post, id);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value="/posts/{id}")
	public void patchPost(@RequestBody Map<String, String> update, @PathVariable int id) {
		service.patchPost(update, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/posts/{id}")
	public void deletePost(@PathVariable int id) {
		service.deletePost(id);
	}
}
