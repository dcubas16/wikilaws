package org.wikilaws.dao;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Nota;

public class AnotacionDAOImpl extends HibernateDaoSupport implements AnotacionDAO {

	@Override
	public List<Nota> obtenerAnotacionesPorLey(Long id_normas) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Nota> notas = session.createQuery("from Nota where leynorma_id_normas = "+id_normas).list();
		session.close();
		return notas;
	}

	@Override
	public boolean registrarAnotacionALey(Long id_normas, String textoLey) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		LeyNorma leyNorma = new LeyNorma();
		leyNorma.setId_normas(id_normas);
		
		Nota nota = new Nota();
		nota.setLeyNorma(leyNorma);
		nota.setTextoLey(textoLey);
		nota.setDescripcionNota("");
		nota.setTodasLeyes(0);
		
		session.save(nota);
		
		session.getTransaction().commit();

		return false;
	}

}
