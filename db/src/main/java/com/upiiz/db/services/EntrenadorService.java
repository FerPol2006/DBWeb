package com.upiiz.db.services;

import com.upiiz.db.entities.EntrenadorEntity;

import java.util.List;

public interface EntrenadorService {

	EntrenadorEntity guardarEntrenador(EntrenadorEntity entrenador);

	List<EntrenadorEntity> listarEntrenadores();

	EntrenadorEntity actualizarEntrenador(EntrenadorEntity entrenador);

	void eliminarEntrenador(Long id);

	EntrenadorEntity obtenerEntrenadorPorId(Long id);
}
