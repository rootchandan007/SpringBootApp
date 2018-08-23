package com.chandan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chandan.model.Notes;
import com.chandan.model.UserInfo;

@Repository("notesRepository")
public interface NotesRepository extends JpaRepository<Notes, Integer>,CrudRepository<Notes, Integer> {
	public List<Notes> findAll();
	UserInfo save(UserInfo user);
	
}