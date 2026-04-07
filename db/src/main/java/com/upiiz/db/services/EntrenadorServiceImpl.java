package com.upiiz.db.services;

import com.upiiz.db.entities.EntrenadorEntity;
import com.upiiz.db.repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

	@Autowired
	private EntrenadorRepository entrenadorRepository;

	@Override
	public EntrenadorEntity guardarEntrenador(EntrenadorEntity entrenador) {
		return entrenadorRepository.save(entrenador);
	}

	@Override
	public List<EntrenadorEntity> listarEntrenadores() {
		return entrenadorRepository.findAll();
	}

	@Override
	public EntrenadorEntity actualizarEntrenador(EntrenadorEntity entrenador) {
		return entrenadorRepository.save(entrenador);
	}

	@Override
	public void eliminarEntrenador(Long id) {
		if (entrenadorRepository.existsById(id)) {
			entrenadorRepository.deleteById(id);
		}
	}

	@Override
	public EntrenadorEntity obtenerEntrenadorPorId(Long id) {
		return entrenadorRepository.findById(id).orElse(null);
	}
}
