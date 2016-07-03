package com.basededatos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basededatos.domain.Usuario;
import com.basededatos.service.UsuarioService;
import com.basededatos.validator.UsuarioValidator;


@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	


	public UsuarioController() {

	}
	
	@InitBinder("usuario")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsuarioValidator());
	}

	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.getAll());
		return "usuarios/usuarioList";
	}

	@RequestMapping("/usuarios/new")
	public String newUsuarioView(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("roles", usuarioService.getRoles());
		return "usuarios/usuario";
	}

	@RequestMapping("/usuarios/edit/{id}")
	public String updateUsuarioView(Model model, @PathVariable Long id) {
		Usuario usuario = usuarioService.get(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("roles", usuarioService.getRoles());
		return "usuarios/usuario";
	}

	@RequestMapping("/usuarios/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		Usuario usuario = usuarioService.get(id);
		usuarioService.delete(usuario);
		return "redirect:/usuario";
	}

	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
		if ((bindingResult.hasErrors())) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("roles", usuarioService.getRoles());
			return "usuarios/usuario";
		}else{
			usuarioService.save(usuario);
			return "redirect:usuarios";
		}
	}

}