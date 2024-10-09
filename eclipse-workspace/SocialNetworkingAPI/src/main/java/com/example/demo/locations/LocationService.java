package com.example.demo.locations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.users.User;

@Service
public class LocationService {
	ArrayList<Location> l1=new ArrayList<Location>();
	public ArrayList<Location>getAllLocations()
	{
		return l1;
	}
	
	public Location getLocation (String id) {
		Location location = getAllLocations().stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);	
		return location ;
	}
	
	public void addLocation(Location location) {
		l1.add(location);
	}
	public boolean updateLocation(String id, Location newLocation) {
	    for (int i = 0; i < l1.size(); i++) {
	        Location currentLocation = l1.get(i);
	        if (currentLocation.getId().equals(id)) {
	            l1.set(i, newLocation);
	            return true; 
	        }
	    }
	    return false;
	}

	public boolean deleteLocation(String id) {
	    return l1.removeIf(location -> location.getId().equals(id));
	}
}
