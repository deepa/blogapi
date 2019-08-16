package site.deepa.blog.repository;

import org.springframework.data.repository.CrudRepository;

import site.deepa.blog.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{

}
