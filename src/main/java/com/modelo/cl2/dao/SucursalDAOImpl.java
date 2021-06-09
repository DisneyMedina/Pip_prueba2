package com.modelo.cl2.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modelo.cl2.entity.Sucursal;

@Repository
public class SucursalDAOImpl implements SucursalDAO{
	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = true)
	@Override
	public List<Sucursal> listAll() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select suc from Sucursal suc";
			query=session.createQuery(hql);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return query.getResultList();
	}
	
	
}
