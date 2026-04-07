package com.upiiz.db.controllers;

import com.upiiz.db.entities.EntrenadorEntity;
import com.upiiz.db.services.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

	@Autowired
	private EntrenadorService entrenadorService;

	@GetMapping
	public String entrenadores(Model model) {
		List<EntrenadorEntity> entrenadores = entrenadorService.listarEntrenadores();
		model.addAttribute("entrenadores", entrenadores);
		return "listado-entrenadores";
	}

	@GetMapping("/nuevo")
	public String nuevoEntrenador(Model model) {
		model.addAttribute("entrenador", new EntrenadorEntity());
		return "agregar-entrenador";
	}

	@PostMapping("/guardar")
	public String guardarEntrenador(@ModelAttribute EntrenadorEntity entrenador) {
		entrenadorService.guardarEntrenador(entrenador);
		return "redirect:/entrenadores";
	}

	@GetMapping("/actualizar/{id}")
	public String actualizarEntrenador(@PathVariable Long id, Model model) {
		EntrenadorEntity entrenador = entrenadorService.obtenerEntrenadorPorId(id);
		if (entrenador == null) {
			return "redirect:/entrenadores";
		}
		model.addAttribute("entrenador", entrenador);
		return "actualizar-entrenador";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable Long id, Model model) {
		EntrenadorEntity entrenador = entrenadorService.obtenerEntrenadorPorId(id);
		if (entrenador == null) {
			return "redirect:/entrenadores";
		}
		model.addAttribute("entrenador", entrenador);
		return "eliminar-entrenador";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable Long id) {
		entrenadorService.eliminarEntrenador(id);
		return "redirect:/entrenadores";
	}
}
