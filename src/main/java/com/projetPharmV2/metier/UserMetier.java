package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.User;

public interface UserMetier {
	public User saveUser(User user);

	public List<User> listeUser();

	public void deleteUser(Long idUser);

	public void updateUser(User user);

	public User findOneUser(Long idUser);

	public User findOneUserByUserNameAndPassword(String login,String password);

	public User findOneUserByUserName(String login);

}
