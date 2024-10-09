package com.example.demo.posts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.locations.Location;
import com.example.demo.users.User;


@Service
public class PostService {
	ArrayList<Post> p1=new ArrayList<Post>();
	public ArrayList<Post>getAllPosts()
	{
		return p1;
	}
	
	public Post getPost (String id) {
		Post post = getAllPosts().stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return post ;
	}
	
	public void addPost(Post post) {
		p1.add(post);
	}
	
	public boolean updatePost(String id, Post newPost) {
	    for (int i = 0; i < p1.size(); i++) {
	    	Post currentPost = p1.get(i);
	        if (currentPost.getId().equals(id)) {
	            p1.set(i, newPost);
	            return true; 
	        }
	    }
	    return false;
	}

	public boolean deletePost(String id) {
	    return p1.removeIf(post -> post.getId().equals(id));
	}
}
