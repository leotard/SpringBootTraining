package com.leo.rest.ws.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	private static List<User> users= new ArrayList<>();
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	private static int usersCounts=3;
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCounts);
			users.add(user);
			return user;
		}else {
			users.add(user);
			return user;
		}
	}
	
	public User findOne(Integer id) {
		Iterator<User> itr= users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if (user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User deleteById(Integer id) {
		Iterator<User> itr= users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if (user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
