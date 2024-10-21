package com.synergisticit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.UserDtls;



public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public UserDtls findByEmail(String email);

	public List<UserDtls> findByRole(String role);

	public UserDtls findByResetToken(String token);
	
	public Optional<UserDtls> findById(Integer id);

	public Boolean existsByEmail(String email);
}
