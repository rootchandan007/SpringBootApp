package com.chandan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.model.UserInfo;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
 
	UserInfo findByEmail(String email);
	@SuppressWarnings("unchecked")
	UserInfo save(UserInfo user);
	

}
