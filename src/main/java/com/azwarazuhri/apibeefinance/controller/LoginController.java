package com.azwarazuhri.apibeefinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.azwarazuhri.apibeefinance.entity.Users;
import com.azwarazuhri.apibeefinance.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
	@Autowired
	UsersRepository userRepository;
	@RequestMapping("/login")
	public String Login() {
		return "hello world";
	}
	
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
//	  public Users create(@RequestBody Users shipwreck){
	  public @ResponseBody Users create( Users shipwreck){
		return userRepository.save(shipwreck);
	  }


	  @RequestMapping(value ="login", method = RequestMethod.POST)
	 public @ResponseBody
	  List<Users> login(String email){
		List<Users>usersList=userRepository.findByEmail(email);
		List<Users>usersListData=new ArrayList<>();
		for(Users users:usersList){
			Users usersData = new Users();
			usersData.setId(users.getId());
			usersData.setEmail(users.getEmail());
			usersData.setName(users.getName());
			usersData.setFirstname(users.getFirstname());
			usersData.setLastname(users.getLastname());
			usersListData.add(usersData);
		}
		return usersListData;
	  }
}
