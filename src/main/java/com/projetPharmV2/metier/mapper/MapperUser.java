package com.projetPharmV2.metier.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projetPharmV2.entities.User;
import com.projetPharmV2.metier.MapperMetier;
import com.projetPharmV2.service.rest.objet.UserRest;

public class MapperUser implements MapperMetier<UserRest, User> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapperUser.class);

	@Override
	public User mapper(UserRest userRest) {
		LOGGER.debug("Entre dans le Mapper User");
		User user = new User();
		user.setActived(userRest.isActived());
		user.setIdUser(userRest.getIdUser());
		user.setUserName(userRest.getUserName());
		user.setNomUser(userRest.getNomUser());
		user.setPassword(userRest.getPassword());
		//user.setAuthorities(mapperListe(userRest.getAuthorities()));
		LOGGER.debug("Sortie du Mapper User");

		return user;
	}

	private List<String> mapperListe(List<String> authorities) {
		List<String> authoritieUserList = new ArrayList<String>();
		if (org.springframework.util.CollectionUtils.isEmpty(authorities)) {
			for (String authoritieUser : authorities) {
				authoritieUserList.add(authoritieUser);
			}
		}
		return authoritieUserList;
	}

	@Override
	public UserRest mapperInverse(User userEntity) {
		LOGGER.debug("Entre dans le MapperInverse User");
		UserRest userRest = new UserRest();
		userRest.setActived(userEntity.isActived());
		userRest.setIdUser(userEntity.getIdUser());
		userRest.setUserName(userEntity.getUserName());
		userRest.setNomUser(userEntity.getNomUser());
		userRest.setPassword(userEntity.getPassword());
		//userRest.setAuthorities(mapperListe(userEntity.getAuthorities()));
		LOGGER.debug("Sortie du MapperInverse User");

		return userRest;
	}



}
