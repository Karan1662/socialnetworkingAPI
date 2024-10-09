package com.example.demo.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.locations.Location;

@RestController
public class UserController {
	@Autowired
	UserService us;
	@RequestMapping(value="/users")
	public List<User> getAllUsers() {
			
			return us.getAllUsers();	
	}
	
	@RequestMapping(value="/users/{id}")
	public User getUser(@PathVariable String id) {
		return us.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addusers")
	public void addUser(@RequestBody User user) {
		us.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateusers/{id}")
	public boolean updateUser(@RequestBody User user ,@PathVariable String id) {
		
		return us.updateUser(id,user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteusers/{id}")
	public boolean deleteUser(@PathVariable String id) {
		return us.deleteUser(id);
	}

}
