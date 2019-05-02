package com.azwarazuhri.apibeefinance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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


//	  @RequestMapping(value ="login", method = RequestMethod.POST)
//	 public @ResponseBody
//	  List<Users> login(String email){
		  //create ObjectMapper instance
//		  ObjectMapper objectMapper = new ObjectMapper();
//		  Gson gson = new Gson();
//		List<Users>usersList=userRepository.findByEmail(email);
//		List<Users>usersListData=new ArrayList<>();
//		for(Users users:usersList){
//			Users usersData = new Users();
//			usersData.setId(users.getId());
//			usersData.setEmail(users.getEmail());
//			usersData.setName(users.getName());
//			usersData.setFirstname(users.getFirstname());
//			usersData.setLastname(users.getLastname());
//			usersListData.add(usersData);
//			//gson.toJson(usersData);
//		}
//		return usersListData;
//	  }

	@RequestMapping(value ="login", method = RequestMethod.POST)
	public @ResponseBody
	  String test(String email){
		Gson gson = new Gson();
		String jsonInString=null;
		List<Users>usersList=userRepository.findByEmail(email);
		for(Users users:usersList){
			Users usersData = new Users();
			usersData.setId(users.getId());
			usersData.setEmail(users.getEmail());
			usersData.setName(users.getName());
			usersData.setFirstname(users.getFirstname());
			usersData.setLastname(users.getLastname());
			//Java object to JSON string
			jsonInString= gson.toJson(usersData);
		}

		return jsonInString;
	  }
}
