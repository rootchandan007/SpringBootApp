package com.chandan.service;

import com.chandan.model.Notes;
import com.chandan.model.UserInfo;

public interface UserService {
	  
	 public UserInfo findUserByEmail(String email);
	 
	 public void saveUser(UserInfo user);
	 Iterable<Notes> getAllNotes();
	 public void deleteNotes(int id);
	 public Notes saveNotes(Notes user);
	 Notes findOne(int id);
 	 UserInfo getDetailsbyId(int id);
	 
	}