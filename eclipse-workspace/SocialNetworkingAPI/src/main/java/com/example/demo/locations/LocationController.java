package com.example.demo.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.User;

@RestController
public class LocationController {
	@Autowired
	LocationService ls;
	@RequestMapping(value="/locations")
	public List<Location> getAllLocations() {
		return ls.getAllLocations();
	}

	@RequestMapping(value="/locations/{id}")
	public Location getLocation(@PathVariable String id) {
		return ls.getLocation(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addlocations")
	public void addLocation(@RequestBody Location location) {
		ls.addLocation(location);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatelocations/{id}")
	public boolean updateLocation(@RequestBody Location location ,@PathVariable String id) {
		
		return ls.updateLocation(id,location);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletelocation/{id}")
	public boolean deleteLocation(@PathVariable String id) {
		return ls.deleteLocation(id);
	}

}
