package com.projetPharmV2.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetPharmV2.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userName like :login and u.password like:password")
	public User findOneUserByUserNameAndPassword(@Param("login") String login, @Param ("password")String password);

	@Query("select u from User u where u.userName like :login")
	public User findOneUserByUserName(@Param("login") String login);

}
