package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BikkadIT.entity.User;
import com.BikkadIT.service.UserServiceI;
@Controller
public class UserController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping("/welcome")
	public String loadForm() {
		return "registration";
		
	}
	@GetMapping("/login")
	public String perlogin() {
		return "login";
		
	}
	@PostMapping("/reg")
	public String userRegistration(User user,Model model) 
	{
		System.out.println("Controller layer method");
		System.out.println(user);
		int id = userServiceI.saveUser(user);
		model.addAttribute("ID", id);
		
		return "userSuccess";
		
	}
	@GetMapping("/log")
	public String loginCheck(User user) {
		System.out.println(user);
		boolean loginCheckServiceLayer = userServiceI.loginCheckServiceLayer(user);
		if(loginCheckServiceLayer) {
			return "loginSuccess";
		}else
		
		return "LoginFail";
		
	}
	@GetMapping("/getAllData")
	public String getAllData(Model model) {
		List<User> all = userServiceI.getAll();
		model.addAttribute("list", all);
		return "getData";
		
	}
	@GetMapping("/getuser/{uid}")
	public String getSingleUser(@PathVariable int uid ,Model model) {
		System.out.println(uid);
		User singleUser = userServiceI.singleUser(uid);
		System.out.println(singleUser);
		model.addAttribute("User", singleUser);
		return "GetUser";
		
	}
	@GetMapping("/up")
	public String preupdate() {
		return "update";
		
	}
	
	@PostMapping("/update")
	public String updateuser(User user ,Model model) {
		List<User> user2 = userServiceI.updateUser(user);
		model.addAttribute("user2", user2);
		
		return "updatelist";
		
	}
	@GetMapping("/delete/{uid}")
	public String deleteuser(@PathVariable int uid)
	{
	   User user = userServiceI.deleteuser(uid);
	   System.out.println(user);
	  // if (user!=null) {
			return "delete";
					//}//return "notdelete";

		
	}

}
