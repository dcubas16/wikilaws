package org.wikilaws.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wikilaws.entities.LeyNorma;
import org.wikilaws.entities.Usuario;
import org.wikilaws.services.UserNavigationHistoryServiceImpl;

@Controller
@RequestMapping("/UserNavigationHistory/")
public class UserNavigationHistoryController {
	
	@Autowired
	private UserNavigationHistoryServiceImpl userNavigationHistoryServiceImpl;
	
	@RequestMapping(value = "registrar_navegacion_usuario.htm", method = RequestMethod.GET)
	public @ResponseBody boolean registrarNavegacionDeUsuario(@RequestParam("id_usuario") Long id_usuario, @RequestParam("id_normas") Long id_normas) {
		
		Usuario usuario = new Usuario();
		usuario.setId_usuario(Long.parseLong("2"));
		usuario.setNombre("diego.nunez");
		usuario.setPassword("123456");
		
		LeyNorma leyNorma = new LeyNorma();
		leyNorma.setId_normas(id_normas);
		
		userNavigationHistoryServiceImpl.registrarNavegacionDeUsuario(usuario, leyNorma, new Date());
		
		return true;
	}
	
}
