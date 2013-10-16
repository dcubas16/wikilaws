package org.wikilaws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wikilaws.entities.LeyNorma;
import org.hibernate.Session;

public class LeyNormaDAOImpl extends HibernateDaoSupport implements
		LeyNormaDAO {

	@Override
	public List<LeyNorma> obtenerLeyesYNormas() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<LeyNorma> leyesYNormas = session.createQuery("from LeyNorma").list();
		session.close();
		return leyesYNormas;
	}

	@Override
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<LeyNorma> leyesYNormas = session.createQuery("from LeyNorma where UPPER(tipo)||UPPER(numero_norma)||UPPER(descripcion) like '%"+criterioBusqueda+"%'").list();
		session.close();
		return leyesYNormas;
	}
	/*
	private String createAndStoreEvent(String title, Date theDate) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        session.getTransaction().commit();
        log.info("Insertado: "+theEvent);
        return theEvent.getId();
    }*/
}
