package org.wikilaws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wikilaws.dao.AnotacionDAO;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Nota;

@Service
public class AnotacionesServiceImpl implements AnotacionesService {

	@Autowired
	private AnotacionDAO anotacionesDAO;
	
	@Override
	public List<Nota> obtenerAnotacionesPorLey(Long id_normas) {
		
		return anotacionesDAO.obtenerAnotacionesPorLey(id_normas);
	}

	@Override
	public boolean registrarAnotacionALey(Long id_normas, String textoLey) {
		
		return anotacionesDAO.registrarAnotacionALey(id_normas, textoLey);
	}

}
