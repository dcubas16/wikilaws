package org.wikilaws.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;
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

	@Override
	public boolean registrarNavegacionDeUsuario(Usuario usuario, LeyNorma leyNorma, Date fechaAcceso) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		HistorialNavegacionDeUsuario historialNavegacionDeUsuario = 
				new HistorialNavegacionDeUsuario(Long.parseLong("1"), Long.parseLong("1"), fechaAcceso, usuario);
		session.save(usuario);
		
		Set<HistorialNavegacionDeUsuario> historialNavegacionDeUsuarios = new HashSet<HistorialNavegacionDeUsuario>(); 
		historialNavegacionDeUsuarios.add(historialNavegacionDeUsuario);
		
		usuario.setHistorialNavegacionDeUsuarios(historialNavegacionDeUsuarios);
		session.getTransaction().commit();
		session.close();

		return false;
	}
}
