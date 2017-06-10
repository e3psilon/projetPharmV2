/*package com.projetPharmV2.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetPharm.entities.User;
import com.projetPharm.metier.UserMetier;
import com.projetPharm.service.rest.objet.Profile;


/**
 * Users resource
 *

@RestController
@RequestMapping(value = "/api")
public class Users {

	@Autowired
	private UserMetier userMetier;

    @RequestMapping("/users")
    public List<User> query(){
        return userMetier.listeUser();
    }

    @RequestMapping("/users/{id}")
    public User query(@PathVariable Long id){
        return userMetier.findOneUser(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody @Valid User user){
         userMetier.updateUser(user);
    }

    @RequestMapping("/users/profiles")
    public List<String> getProfiles(){
        List<String> profiles = new ArrayList<>();
        for(Profile profile: Profile.values()){
            profiles.add(profile.name());
        }
        return profiles;
    }
}
*/