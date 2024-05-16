package nz.co.stylesoftware.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nz.co.stylesoftware.SpringSecurity.dao.UserRepo;
import nz.co.stylesoftware.SpringSecurity.entity.Users;
import nz.co.stylesoftware.SpringSecurity.model.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = repo.getByUserId(Integer.valueOf(username));
		//System.out.println("Inside loadUserByUsername "+user.getPassword());
		if(user == null) {
			System.out.println("User 404");
			throw new UsernameNotFoundException("User 404");
		}
		return new UserPrincipal(user);
	}
	

}
