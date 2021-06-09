package com.modelo.cl2.service;
import java.util.List;

import com.modelo.cl2.entity.Supervisor;

public interface SupervisorService {

	public void delete(int cod);
	public List<Supervisor> listAllSupervisorxSucursal(int codSucu);
}

