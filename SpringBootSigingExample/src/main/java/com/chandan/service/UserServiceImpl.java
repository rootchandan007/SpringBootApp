package com.chandan.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.model.Notes;
import com.chandan.model.UserInfo;
import com.chandan.repository.NotesRepository;
import com.chandan.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotesRepository notesRepository;

	@Override
	public UserInfo findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserInfo user) {
		user.setPassword(user.getPassword());
		if (user.getRole() == "Admin") {
			user.setEnabled("1");
		} else {
			user.setEnabled("0");
		}

	}

	@Override
	public Iterable<Notes> getAllNotes() {
		return notesRepository.findAll();
	}

	@Override
	public void deleteNotes(int id) {

		notesRepository.deleteById(id);

	}

	@Override
	public Notes saveNotes(Notes user) {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		user.setCreation_date(today);
		user.setUpdate_date(today);
		return notesRepository.save(user);

	}

	@Override
	public Notes findOne(int notes_id) {
		Optional<Notes> optional = notesRepository.findById(notes_id);
		Notes emp = optional.get();
		// optional.orElseThrow(() -> new UsernameNotFoundException("user name not
		// found"));
		// return optional.map(EmployeeServiceImpl::new).get();
		// return employeeRepository.findOne(id);
		return notesRepository.save(emp);
	}

	@Override
	public UserInfo getDetailsbyId(int id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

}