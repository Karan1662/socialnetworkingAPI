package com.example.demo.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.locations.Location;

@RestController
public class PostController {
	@Autowired
	PostService ps;
	@RequestMapping(value="/posts")
	public List<Post> getAllPosts() {
			return ps.getAllPosts();	
	}
	
	@RequestMapping(value="/posts/{id}")
	public Post getPost(@PathVariable String id) {
		return ps.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addposts")
	public void addPost(@RequestBody Post post) {
		ps.addPost(post);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateposts/{id}")
	public boolean updatePost(@RequestBody Post post ,@PathVariable String id) {
		
		return ps.updatePost(id,post);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteposts/{id}")
	public boolean deletePost(@PathVariable String id) {
		return ps.deletePost(id);
	}

}
