package com.upiiz.db.services;

import com.upiiz.db.entities.JugadorEntity;
import com.upiiz.db.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;
    @Override
    public JugadorEntity guardarJugador(JugadorEntity jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public List<JugadorEntity> listarJugadores() {
        return jugadorRepository.findAll();
    }

    @Override
    public JugadorEntity actualizarJugador(JugadorEntity jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void eliminarJugador(Long id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
        }
    }

    @Override
    public JugadorEntity obtenerJugadorPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }
}
