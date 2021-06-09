package com.modelo.cl2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.cl2.dao.SucursalDAO;
import com.modelo.cl2.entity.Sucursal;

@Service
public class SucursalServiceImpl implements SucursalService{

	@Autowired
	private SucursalDAO sucursalDAO;
	@Override
	public List<Sucursal> listAll() {
		// TODO Auto-generated method stub
		return sucursalDAO.listAll();
	}

}
