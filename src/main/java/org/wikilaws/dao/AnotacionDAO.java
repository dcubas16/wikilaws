package org.wikilaws.dao;

import java.util.List;

import org.wikilaws.entities.Nota;

public interface AnotacionDAO {

	public List<Nota> obtenerAnotacionesPorLey(Long id_normas);
	public boolean registrarAnotacionALey(Long id_normas, String textoLey);
}
