package in.sp.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entity.User;
import in.sp.main.service.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/regpage")
	public String registerHere(Model model) {
		model.addAttribute("user", new User());
		return "register";
		
	}
	
	@PostMapping("/regForm")
	public String submitRgForm(@ModelAttribute("user") User user,Model model) {
			boolean status= userService.registerUser(user);
			if(status) {
				model.addAttribute("successMsg","User Registered Successfully");
			}
			else {
				model.addAttribute("errorMsg","User not Registered Successfully");
			}
			//System.out.println("I am registering myself");
			return "register";
		
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user",new User());
		return "login";
		
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser=userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser!=null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}
		else {
			model.addAttribute("errorMsg", "Email and password didn't match");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "redirect:/loginPage";
	}
	
	@GetMapping("getAllUsers")
	public String getAllUsers(Model model) {
		List<User> allUsers= userService.getAllUsers();
		model.addAttribute("users", allUsers);
		return "getAllUsers";
	}

}
