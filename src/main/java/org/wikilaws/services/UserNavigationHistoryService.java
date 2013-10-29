package org.wikilaws.services;

import java.util.Date;
import java.util.List;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;

public interface UserNavigationHistoryService {
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso);
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(Long id_usuario);
}
