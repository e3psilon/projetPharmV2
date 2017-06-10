package com.projetPharmV2.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetPharmV2.entities.Role;
import com.projetPharmV2.entities.dao.RoleRepository;
import com.projetPharmV2.metier.RoleMetier;
@Service
public class RoleMetierImpl implements RoleMetier{
	@Autowired
	RoleRepository roleRepository;
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> listeRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void deleteRole(Long idRole) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public Role findOneRole(Long idRole) {
		return roleRepository.findOne(idRole);
	}

}
