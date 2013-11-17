package org.wikilaws.services;

import java.util.Date;
import java.util.List;

import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Nota;
import org.wikilaws.entities.Usuario;

public interface AnotacionesService {
	
	public List<Nota> obtenerAnotacionesPorLey(Long id_normas);
	public boolean registrarAnotacionALey(Long id_normas, String textoLey);
}
