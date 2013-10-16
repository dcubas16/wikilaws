package org.wikilaws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.services.LeyesYNormasServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private LeyesYNormasServiceImpl leyesYNormasServiceImpl;
	
	@RequestMapping(value="home.htm", method=RequestMethod.GET )
	public String home(Model model)
	{
		return "home";
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
		
		return "resultados_busqueda";
	}
	
//	@RequestMapping(value="resultados_busqueda.htm", method=RequestMethod.GET )
//	public  resultados_busqueda(@RequestParam("searchInput") String searchInput, Model model)
//	{
//		if(searchInput.isEmpty()) return "resultados_busqueda";
//		
//		String correctSearchInput = searchInput.replace(' ', '%').toUpperCase();
//		System.out.println("---------->CADENA DE BUSQUEDA CORRECTA"+correctSearchInput);
//		
//		List<LeyNorma> leyesYNormas = leyesYNormasServiceImpl.obtenerLeyesYNormasPorBuscador(correctSearchInput);
//		
//		model.addAttribute("leyesYNormas", leyesYNormas);
//		model.addAttribute("searchInput", searchInput);
//		
//		return "resultados_busqueda";
//	}
	
	@RequestMapping(value="contenido_pagina.htm", method=RequestMethod.GET )
	public String contenido_pagina(@RequestParam("url") String url, Model model)
	{
		if(url.isEmpty()) return "resultados_busqueda";
		
//		System.out.println("---------->CADENA DE URL"+url);
//		
//		String pageContent = leyesYNormasServiceImpl.readHtmlFile(url);
//		System.out.println("---------->CONTENIDO DE PAGINA"+pageContent);
		model.addAttribute("url", url);
		
		return "contenido_pagina";
	}
}