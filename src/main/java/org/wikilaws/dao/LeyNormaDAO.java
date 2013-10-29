package org.wikilaws.dao;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;

@Transactional(propagation = Propagation.REQUIRED)
public interface LeyNormaDAO {

	public List<LeyNorma> obtenerLeyesYNormas();
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda);
	public boolean registrarNavegacionDeUsuario(Usuario user, LeyNorma leyNorma, Date fechaAcceso);
	public List<HistorialNavegacionDeUsuario> obtenerHistorialNavegacionDeUsuario(Long id_usuario);
}
