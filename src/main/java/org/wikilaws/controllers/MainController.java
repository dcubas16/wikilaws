package org.wikilaws.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wikilaws.entities.HistorialNavegacionDeUsuario;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Nota;
import org.wikilaws.services.AnotacionesServiceImpl;
import org.wikilaws.services.LeyesYNormasServiceImpl;
import org.wikilaws.services.UserNavigationHistoryServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private LeyesYNormasServiceImpl leyesYNormasServiceImpl;
	
	@Autowired
	private UserNavigationHistoryServiceImpl userNavigationHistoryServiceImpl;
	
	@Autowired
	private AnotacionesServiceImpl anotacionesServiceImpl;

	
	@RequestMapping(value="login.htm", method=RequestMethod.GET )
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping(value="home.htm", method=RequestMethod.GET )
	public String home(Model model)
	{
		List<HistorialNavegacionDeUsuario> historialNavegacionDeUsuario = userNavigationHistoryServiceImpl.obtenerHistorialNavegacionDeUsuario(Long.parseLong("1"));
		model.addAttribute("historialNavegacionDeUsuario", historialNavegacionDeUsuario);
		
		return "home";
	}
	
	@RequestMapping(value="historial_navegacion.htm", method=RequestMethod.GET )
	public String historialNavegacion(Model model)
	{
		List<HistorialNavegacionDeUsuario> historialNavegacionDeUsuario = userNavigationHistoryServiceImpl.obtenerHistorialNavegacionDeUsuario(Long.parseLong("1"));
		model.addAttribute("historialNavegacionDeUsuario", historialNavegacionDeUsuario);
		
		return "historial_navegacion";
	}
	
	@RequestMapping(value="resultados_busqueda.htm", method=RequestMethod.GET )
	public String resultados_busqueda(@RequestParam("searchInput") String searchInput, Model model)
	{
		if(searchInput.isEmpty()) return "resultados_busqueda";
		
		String correctSearchInput = searchInput.replace(' ', '%').toUpperCase();
		System.out.println("---------->CADENA DE BUSQUEDA CORRECTA"+correctSearchInput);
		
		List<LeyNorma> leyesYNormas = leyesYNormasServiceImpl.obtenerLeyesYNormasPorBuscador(correctSearchInput);
		
		model.addAttribute("leyesYNormas", leyesYNormas);
		model.addAttribute("searchInput", searchInput);
		List<HistorialNavegacionDeUsuario> historialNavegacionDeUsuario = userNavigationHistoryServiceImpl.obtenerHistorialNavegacionDeUsuario(Long.parseLong("1"));
		model.addAttribute("historialNavegacionDeUsuario", historialNavegacionDeUsuario);
		
		
		return "resultados_busqueda";
	}
	
	@RequestMapping(value="contenido_pagina.htm", method=RequestMethod.GET )
	public String contenido_pagina(@RequestParam("url") String url, @RequestParam("id_normas") Long id_normas, Model model)
	{
		if(url.isEmpty()) return "resultados_busqueda";
		
		model.addAttribute("url", url);
		model.addAttribute("id_normas", id_normas);
		List<HistorialNavegacionDeUsuario> historialNavegacionDeUsuario = userNavigationHistoryServiceImpl.obtenerHistorialNavegacionDeUsuario(Long.parseLong("1"));
		model.addAttribute("historialNavegacionDeUsuario", historialNavegacionDeUsuario);
		List<Nota> notas = anotacionesServiceImpl.obtenerAnotacionesPorLey(id_normas);
		model.addAttribute("notas", notas);
		
		return "contenido_pagina";
	}

	@RequestMapping(value = "resultados_busqueda_ajax.htm", method = RequestMethod.GET)
	public @ResponseBody List<LeyNorma> resultados_busqueda_ajax(@RequestParam("searchInput") String searchInput, Model model) {
		if(searchInput.isEmpty()) return null;
		
		String correctSearchInput = searchInput.replace(' ', '%').toUpperCase();
		System.out.println("---------->CADENA DE BUSQUEDA CORRECTA: "+correctSearchInput);
		
		List<LeyNorma> leyesYNormas = leyesYNormasServiceImpl.obtenerLeyesYNormasPorBuscador(correctSearchInput);
		
		for (LeyNorma leyNorma : leyesYNormas) {
			leyNorma.setHistorialNavegacionDeUsuarios(null);
			leyNorma.setNotas(null);
		}
		
		return leyesYNormas;
	}
	

}