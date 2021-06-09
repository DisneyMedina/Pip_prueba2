package com.modelo.cl2.dao;
import java.util.List;

import com.modelo.cl2.entity.Supervisor;

public interface SupervisorDAO {

	public void delete(int cod);
	public List<Supervisor> listAllSupervisorxSucursal(int codSucu);
}

