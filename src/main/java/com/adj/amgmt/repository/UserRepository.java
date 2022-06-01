package com.adj.amgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adj.amgmt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByusername(String UserName);
	
	/*
	 * @Query("select u from User u where u.username=:username") User
	 * findByusername(@Param("username") String username);
	 */
}
