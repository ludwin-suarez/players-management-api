package com.example.registerjugadordotaweb.repository;

import com.example.registerjugadordotaweb.model.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorDotaRepository extends JpaRepository  <Jugador, Long> {
        List<Jugador> findAllByState(Boolean state);
        Optional<Jugador> findByIdAndState(Long id, Boolean state);
        Optional<Jugador> findByStateAndRoleAndEquipo(Boolean state, int idrole,int idEquipo);
        Optional<Jugador> findByEquipoAndIsCaptain(int idEquipo,boolean isCaptain);

    }
