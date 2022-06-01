package com.adj.amgmt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adj.amgmt.entity.User;
import com.adj.amgmt.entity.UserRole;
import com.adj.amgmt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("------------username----->"+username);
		
//		User userRepo = userRepository.findByusername(username);
		UserRole role=new UserRole();
		UserRole role1=new UserRole();
		role.setUserRoleId(1);
		role.setName("ROLE_ADMIN");
		role1.setUserRoleId(2);
		role1.setName("ROLE_USER");
		Set<UserRole> r=new HashSet<UserRole>();
		r.add(role1);
		r.add(role);
		User userRepo =new User("root", "12", true, r);
		System.out.println("---------hello there -----------> "+userRepo.getUsername()+" : "+userRepo.getPassword());
		CustomUserDetails customUserDetails = null;
		/*
		 * if (userRepo == null) { throw new
		 * UsernameNotFoundException("User does Not Found..."); }
		 */
		customUserDetails = new CustomUserDetails(userRepo);
		return customUserDetails;
	}

}
