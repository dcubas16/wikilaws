package org.wikilaws.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;
import org.hibernate.Session;

public class LeyNormaDAOImpl extends HibernateDaoSupport implements
		LeyNormaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<LeyNorma> obtenerLeyesYNormas() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<LeyNorma> leyesYNormas = session.createQuery("from LeyNorma").list();
		session.close();
		return leyesYNormas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<LeyNorma> leyesYNormas = session.createQuery("from LeyNorma where UPPER(tipo)||UPPER(numero_norma)||UPPER(descripcion) like '%"+criterioBusqueda+"%'").list();
		session.close();
		return leyesYNormas;
	}

	@Override
	public boolean registrarNavegacionDeUsuario(Usuario usuario, LeyNorma leyNorma, Date fechaAcceso) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		HistorialNavegacionDeUsuario historialNavegacionDeUsuario = new HistorialNavegacionDeUsuario();
		
		historialNavegacionDeUsuario.setFecha_acceso(fechaAcceso);
		historialNavegacionDeUsuario.setLeyNorma(leyNorma);
		historialNavegacionDeUsuario.setUsuario(usuario);
		
		usuario.getHistorialNavegacionDeUsuarios().add(historialNavegacionDeUsuario);
		
		session.save(historialNavegacionDeUsuario);
		
		session.getTransaction().commit();

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(
			Long id_usuario) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<HistorialNavegacionDeUsuario> historialNavegacionDeUsuario = session.createQuery("from HistorialNavegacionDeUsuario").list();
		
		session.close();
		return historialNavegacionDeUsuario;
	}
}
