package com.modelo.cl2.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modelo.cl2.entity.Supervisor;

@Repository
public class SupervisorDAOImpl implements SupervisorDAO {

	// atributo de conexión
	@Autowired
	private SessionFactory factory;

	@Transactional
	@Override
	public void delete(int cod) {
		Session session = factory.getCurrentSession();
		try {
			Supervisor bean = session.get(Supervisor.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Transactional(readOnly = true)
	@Override
	public List<Supervisor> listAllSupervisorxSucursal(int codSucu) {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {

			String hql = "select s.cod_supervisor,s.nom_supervisor,s.ape_supervisor,s.dni_supervisor,s.num_hijos,s.sueldo,su.nom_sucursal from tb_supervisor s inner join tb_sucursal su on s.cod_sucursal = su.cod_sucursal where s.cod_sucursal = ?";
			query = session.createSQLQuery(hql);
			query.setParameter(1, codSucu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
