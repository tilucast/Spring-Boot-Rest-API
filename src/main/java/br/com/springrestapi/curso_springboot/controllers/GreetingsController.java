package br.com.springrestapi.curso_springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrestapi.curso_springboot.model.UserApp;
import br.com.springrestapi.curso_springboot.repository.UserAppRepository;

@RestController
public class GreetingsController {
	
	@Autowired
	private UserAppRepository userAppRepository;
   
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<UserApp>> findUser(@PathVariable Long id) {
    	
    	Optional<UserApp> user = userAppRepository.findById(id);
    	
    	if(!user.isPresent()) {
    		//return new ResponseEntity
    	}
    	
    	return new ResponseEntity<Optional<UserApp>>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String mainUrl() {
    	return "App is running boi";
    }
    
    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity<List<UserApp>> listUsers(){
    	List<UserApp> users = userAppRepository.findAll();
    	return new ResponseEntity<List<UserApp>>(users, HttpStatus.OK);
    }
    
    @PostMapping(name = "/users")
    @ResponseBody
    public ResponseEntity<UserApp> create(@RequestBody UserApp user){
    	UserApp createdUser = userAppRepository.save(user);
    	
    	return new ResponseEntity<UserApp>(createdUser, HttpStatus.CREATED);
    }
}