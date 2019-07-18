package com.leo.rest.ws.restfulwebservices.user;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	UserDAOService Users = new UserDAOService();
	
	@GetMapping(path = "/users")
	public List<User> retrieveAll(){
		return Users.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = Users.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-" + id);
		
		EntityModel<User> model = new EntityModel<User>(user);
		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).retrieveAll());
		
		model.add(linkTo.withRel("all-users"));
		
		return model;
		
	}
	
	@DeleteMapping(path = "/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = Users.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-" + id);
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = Users.save(user);
		
		//return a "created status"
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
					.path("/{id}")
						.buildAndExpand(savedUser
							.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
