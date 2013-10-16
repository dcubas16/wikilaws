package org.wikilaws.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wikilaws.entities.LeyNorma;

@Transactional(propagation = Propagation.REQUIRED)
public interface LeyNormaDAO {

	public List<LeyNorma> obtenerLeyesYNormas();
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda);

}
