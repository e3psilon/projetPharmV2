package com.projetPharmV2.metier;

import java.util.List;

import com.projetPharmV2.entities.Role;

public interface RoleMetier {
	public Role saveRole(Role role);

	public List<Role> listeRole();

	public void deleteRole(Long idRole);

	public void updateRole(Role role);

	public Role findOneRole(Long idRole);
}
