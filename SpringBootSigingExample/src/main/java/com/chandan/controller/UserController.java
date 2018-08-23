package com.chandan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chandan.model.Notes;
import com.chandan.model.UserInfo;
//import com.chandan.service.SecurityService;
import com.chandan.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/signin" }, method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("Hello");
		ModelAndView model = new ModelAndView();
		model.setViewName("user/signin");
		return model;
	}

	@RequestMapping(value = { "/signin" }, method = RequestMethod.POST)
	public ModelAndView loginValidation(@Valid UserInfo user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		UserInfo user1 = new UserInfo();

		UserInfo userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			user1.setEmail(user.getEmail());

			if (userExists.getEmail().equals(user.getEmail()) && userExists.getPassword().equals(user.getPassword())) {
				if (userExists.getRole().equals("ADMIN")) {
					model.addObject("usernotes", userService.getAllNotes());
					model.setViewName("user/view");
				} else {
					model.setViewName("home/user_note");
				}
			} else {
				System.out.println("Email is not Exist");
				bindingResult.rejectValue("login", "error.user", "This login is not exists!");
				model.setViewName("user/signin");
			}
		} else {
			System.out.println("Email is not Exist");
			bindingResult.rejectValue("login", "error.user", "This login is not exists!");
			model.setViewName("user/signin");
		}
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		UserInfo user = new UserInfo();
		model.addObject("user", user);
		model.setViewName("user/signup");
		return model;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid UserInfo user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		UserInfo userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			if (userExists.getRole() != null) {

				if (userExists.getRole().toUpperCase().equals("ADMIN")) {
					user.setEnabled("1");
				} else {
					user.setEnabled("0");
				}
			}
			// System.out.println("createUser" + userExists.getUserName() + "Role:" +
			// userExists.getRole());
			userService.saveUser(user);
			model.addObject("msg", "User has been registered successfully!");
			model.addObject("user", new UserInfo());
			model.setViewName("user/signup");
		}

		return model;
	}

	@RequestMapping(value = { "/signintologin" }, method = RequestMethod.GET)
	public String signin(Model model, RedirectAttributes redirect) {

		return "redirect:/signin";
	}

	@RequestMapping(value = { "/add_note" }, method = RequestMethod.GET)
	public String addNote(RedirectAttributes redirect) {
		// ModelAndView model = new ModelAndView();
		// model.addObject("usernotes", userService.getAllNotes());
		// model.setViewName("home/user_note");
		return "redirect:/user_note";
	}

	@RequestMapping(value = { "/user_note" }, method = RequestMethod.GET)
	public ModelAndView userNote() {
		ModelAndView model = new ModelAndView();
		UserInfo user = new UserInfo();
		model.addObject("user", user);
		model.setViewName("home/user_note");
		return model;
	}

	@RequestMapping(value = { "/user_note" }, method = RequestMethod.POST)
	public ModelAndView addNotes(@Valid Notes user, BindingResult bindingResult, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView();
		System.out.println(
				"Notes_id:" + user.getNotes_id() + "Title- " + user.getTitle() + "Role:" + user.getDescription());
		Notes notes = userService.saveNotes(user);

		if (notes == null) {
			bindingResult.rejectValue("Notes", "error.user", "This notes already exists!");
		} else {
			model.addObject("msg", "User has been inserted successfully!");
			model.addObject("user", new Notes());
			model.setViewName("home/user_note");
		}
		return model;
	}

	@RequestMapping(value = { "/view_page" }, method = RequestMethod.GET)
	public ModelAndView viewPage(RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView();
		model.addObject("usernotes", userService.getAllNotes());
		model.setViewName("user/view");
		return model;
	}

	@RequestMapping(value = { "/view" }, method = RequestMethod.GET)
	public ModelAndView view(@Valid UserInfo user, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView();
		UserInfo user1 = new UserInfo();
		System.out.println("Testing333" + " Get  " + user1.getEmail() + " Id " + user.getId() + " " + user.getEmail());
		UserInfo userExists = userService.findUserByEmail(user.getEmail());
		if (userExists.getEmail() != null) {
			System.out.println(userExists.getEmail());
			System.out.println(userExists.getEmail());
			UserInfo userinfo = userService.getDetailsbyId(userExists.getId());
			System.out.println("getRole from db " + userinfo.getRole());
			if (userinfo.getRole().equals("ADMIN")) {
				model.addObject("usernotes", userService.getAllNotes());
				model.setViewName("user/view");
			}
		} else {
			redirect.addFlashAttribute("Error", "Not Available!");
			model.setViewName("user/view");
		}

		model.setViewName("home/user_note");

		return model;
	}

	@GetMapping("/user/{notes_id}/edit")
	public String editDetail(@PathVariable int notes_id, Model model) {
		model.addAttribute("user", userService.findOne(notes_id));
		return "user/form";
	}

	@PostMapping("/user/save")
	public ModelAndView saveInfo(@Valid Notes note, BindingResult result, RedirectAttributes redirect,
			ModelAndView model) {
		if (result.hasErrors()) {
			model.setViewName("user/view");

		}
		Notes notes = userService.saveNotes(note);

		if (notes == null) {
			result.rejectValue("Notes", "error.user", "This notes already exists!");
		} else {
			model.addObject("msg", "User has been inserted successfully!");

			model.addObject("usernotes", userService.getAllNotes());
			model.setViewName("user/view");
			redirect.addFlashAttribute("success", "Saved employee successfully!");
		}
		return model;
	}

	@RequestMapping(value = { "/user/{notes_id}/delete" }, method = RequestMethod.GET)
	public ModelAndView deleteInfo(@PathVariable int notes_id, RedirectAttributes redirect, ModelAndView model) {

		System.out.println("deleteInfo:" + notes_id);
		userService.deleteNotes(notes_id);
		model.addObject("usernotes", userService.getAllNotes());
		model.setViewName("user/view");
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model, String error, String logout) {
		if (error != null)
			model.addObject("error", "Your username and password is invalid.");

		if (logout != null)
			model.addObject("message", "You have been logged out successfully.");
		model.setViewName("user/signin");
		return model;
	}

}