package com.upiiz.db.services;

import com.upiiz.db.entities.JugadorEntity;

import java.util.List;

public interface JugadorService {
    JugadorEntity guardarJugador(JugadorEntity jugador);
    List<JugadorEntity> listarJugadores();
    JugadorEntity actualizarJugador(JugadorEntity jugador);
    void eliminarJugador(Long id);
    JugadorEntity obtenerJugadorPorId(Long id);
}
