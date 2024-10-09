package com.example.demo.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.locations.Location;

@Service
public class UserService {
	ArrayList<User> u1=new ArrayList<User>();
	public ArrayList<User>getAllUsers() {
		return u1;
	}
	
	public User getUser (String id) {
		User user = getAllUsers().stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return user ;
	}
	
	public void addUser(User user) {
		u1.add(user);
	}
	
	public boolean updateUser(String id, User newUser) {
	    for (int i = 0; i < u1.size(); i++) {
	        User currentUser = u1.get(i);
	        if (currentUser.getId().equals(id)) {
	            u1.set(i, newUser);
	            return true; 
	        }
	    }
	    return false;
	}

	public boolean deleteUser(String id) {
	    return u1.removeIf(user -> user.getId().equals(id));
	}

}

