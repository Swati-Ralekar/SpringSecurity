package nz.co.stylesoftware.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nz.co.stylesoftware.SpringSecurity.dao.UserRepo;
import nz.co.stylesoftware.SpringSecurity.entity.Users;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	
	public Users getByUserId(Integer id) {
		return repo.getByUserId(id);
	}
	
	public Users saveUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return repo.save(user);
	}
}
