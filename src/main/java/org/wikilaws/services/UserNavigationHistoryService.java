package org.wikilaws.services;

import java.util.Date;

import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;

public interface UserNavigationHistoryService {
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso);
}
