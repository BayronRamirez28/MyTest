package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IRole;
import com.flofyhome.FLOFYHOME.model.Role;
import com.flofyhome.FLOFYHOME.repository.RolRepository;

@Service
public class RoleDao implements IRole{

	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Role> findAll() {
		return this.rolRepository.findAll();
	}
	
	
}
