package org.wikilaws.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wikilaws.dao.LeyNormaDAO;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;

@Service
public class UserNavigationHistoryServiceImpl implements
		UserNavigationHistoryService {

	@Autowired
	private LeyNormaDAO leyNormaDAO;
	
	@Autowired
	public UserNavigationHistoryServiceImpl(LeyNormaDAO leyNormaDAO){
		this.leyNormaDAO = leyNormaDAO;
	}
	
	@Override
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso) {
		return leyNormaDAO.registrarNavegacionDeUsuario(user, leyNorma, fechaAcceso);
	}

}
