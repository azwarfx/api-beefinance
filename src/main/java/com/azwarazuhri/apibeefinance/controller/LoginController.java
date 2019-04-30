package com.azwarazuhri.apibeefinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.azwarazuhri.apibeefinance.entity.Users;
import com.azwarazuhri.apibeefinance.repository.UsersRepository;

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
}
