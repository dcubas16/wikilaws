package org.wikilaws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wikilaws.dao.LeyNormaDAO;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.filereader.HtmlFileReader;

@Service
public class LeyesYNormasServiceImpl implements LeyesYNormasService{
	
	private LeyNormaDAO leyNormaDAO;
	
	@Autowired
	private HtmlFileReader htmlFileReader;
	
	@Autowired
	public LeyesYNormasServiceImpl(LeyNormaDAO leyNormaDAO){
		this.leyNormaDAO = leyNormaDAO;
	}
	
	@Override
	public List<LeyNorma> obtenerLeyesYNormas(){
		return leyNormaDAO.obtenerLeyesYNormas();
	}
	
	@Override
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda) {
		return leyNormaDAO.obtenerLeyesYNormasPorBuscador(criterioBusqueda);
	}

	@Override
	public String readHtmlFile(String url) {
		return htmlFileReader.readFile(url);
	}
}
