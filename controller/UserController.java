package nz.co.stylesoftware.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nz.co.stylesoftware.SpringSecurity.dao.UserRepo;
import nz.co.stylesoftware.SpringSecurity.entity.Users;
import nz.co.stylesoftware.SpringSecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("getUsers")
	public Users getUsers(@RequestParam Integer id){
		Users user = userService.getByUserId(id);
		if(user == null) {
			return new Users();
		}
		return user;
	}
	
	@PostMapping("register")
	public Users addUser(@RequestBody Users user) {
		userService.saveUser(user);
		return user;
	}
}
