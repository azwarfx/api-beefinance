package com.azwarazuhri.apibeefinance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azwarazuhri.apibeefinance.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
	public Users findById(Long id);
	public List<Users>findAll();
	List<Users> findByEmail(String email);
}
