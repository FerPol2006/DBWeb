package com.upiiz.db.controllers;

import com.upiiz.db.entities.JugadorEntity;
import com.upiiz.db.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public String jugadores(Model model) {
        List<JugadorEntity> jugadores = jugadorService.listarJugadores();
        model.addAttribute("jugadores", jugadores);
        return "listado-jugadores";

    }

    @GetMapping("/nuevo")
    public String nuevoJugador(Model model) {
        model.addAttribute("jugador", new JugadorEntity());
        return "agregar-jugador";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute JugadorEntity jugador) {
        jugadorService.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarJugador(@PathVariable Long id, Model model) {
        JugadorEntity jugador = jugadorService.obtenerJugadorPorId(id);
        if (jugador == null) {
            return "redirect:/jugadores";
        }
        model.addAttribute("jugador", jugador);
        return "actualizar-jugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id, Model model) {
        JugadorEntity jugador = jugadorService.obtenerJugadorPorId(id);
        if (jugador == null) {
            return "redirect:/jugadores";
        }
        model.addAttribute("jugador", jugador);
        return "eliminar-jugador";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        return "redirect:/jugadores";
    }

}
