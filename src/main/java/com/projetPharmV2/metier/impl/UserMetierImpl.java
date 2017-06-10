package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.User;
import com.projetPharmV2.entities.dao.UserRepository;
import com.projetPharmV2.metier.UserMetier;

@Service
public class UserMetierImpl implements UserMetier {

	@Autowired
	UserRepository userRepository;

	//@Autowired
	//private MapperUser mapperUser;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listeUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		//User user2 = findOneUser(user.getIdUser());
		userRepository.save(user);
	}

	@Override
	public User findOneUser(Long idUser) {
		return userRepository.findOne(idUser);
	}


	@Override
	public User findOneUserByUserNameAndPassword(String login, String password) {

		return userRepository.findOneUserByUserNameAndPassword(login, password);
	}

	@Override
	public User findOneUserByUserName(String login) {

		return userRepository.findOneUserByUserName(login);
	}

}
