package com.ludwin.dota.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.ludwin.dota.model.domain.player;
import com.ludwin.dota.model.request.JugadorDotaRequest;
import com.ludwin.dota.model.response.JugadorDotaResponse;
import com.ludwin.dota.repository.JugadorDotaRepository;

import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Para injection de dependencias, trabaja sólo con variables requeridas: tipo final
@Slf4j
public class JugadorDotaService implements JugadoresDotaServiceInterface {
    private final JugadorDotaRepository jugadorDotaRepository;

    @Override
    public List<JugadorDotaResponse> list() {
        return jugadorDotaRepository.findAllByState(true).stream().map(jugador -> {
            return mapToResponse(jugador);
        }).collect(Collectors.toList());
    }

    private JugadorDotaResponse mapToResponse(player jugador) {
        return JugadorDotaResponse.builder()
                .id(jugador.getId())
                .dni(jugador.getDni())
                .name(jugador.getName())
                .lastname(jugador.getLastname())
                .age(jugador.getAge())
                .iscaptain(jugador.isIscaptain())
                .description(jugador.getDescription())
                .state(jugador.getState())
                .equipo_id(jugador.getEquipo_id())
                .rol_id(jugador.getRol_id())
                .build();
    }

    //Crear un registro
    @Override
    public JugadorDotaResponse createJugadorDota(JugadorDotaRequest request) throws Exception {//
        int equipo = request.getEquipo_id();
        int rol = request.getRol_id();
        boolean isCaptain = request.isIscaptain();
        player jugador = jugadorDotaRepository.findByStateAndRoleAndEquipo(true, rol, equipo).orElse(null);
        if (jugador != null) {
            return null;
        } else {
            player jugador2 = jugadorDotaRepository.findByEquipoAndIsCaptain(equipo, true).orElse(null);

            if (jugador2 != null) {
                isCaptain = false;
            }
            jugador = jugador.builder()
                    .dni(request.getDni())
                    .name(request.getName())
                    .lastname(request.getLastname())
                    .age(request.getAge())
                    .iscaptain(isCaptain)//
                    .description(request.getDescription())
                    .state(true)
                    .equipo_id(request.getEquipo_id())
                    .rol_id(request.getRol_id())
                    .build();
            // log.info("product:{}", product);
            jugador = jugadorDotaRepository.save(jugador);

            return mapToResponse(jugador);
        }
    }

    //Consultar un registro
    @Override
    public JugadorDotaResponse getJugadorDotaById(Long id) {
        player jugador = jugadorDotaRepository.findByIdAndState(id, true).orElse(null);
        if (jugador == null)
            return null;
        return mapToResponse(jugador);
    }

    public JugadorDotaResponse updateAsignateCaptain(Long id) {//throws ParseException
        player jugador = jugadorDotaRepository.findByIdAndState(id, true).orElse(null);
        if (jugador == null)
            return null; //si existe lo vamos a actualizr
        else {
            jugador.setIscaptain(false);
            jugadorDotaRepository.save(jugador);
        }
        return mapToResponse(jugador);//retorna el objeto actualizado
    }

    //Actualizar un registro
    /* INGRESA EL ID DEL ANTIGUO CAMPITAN Y EL ID DEL NUEVO CAPITAN - QUITA EL ESTADO CAPITAN AL PRIMERO Y ASIGNA AL NUEVO*/
    @Override
    public JugadorDotaResponse updateJugadorDotaNewCaptain(Long idExCaptain, Long idNewCaptain) {//throws ParseException
        player exJugador = jugadorDotaRepository.findByIdAndState(idExCaptain, true).orElse(null);
        player newJugador = jugadorDotaRepository.findByIdAndState(idNewCaptain, true).orElse(null);
        if (exJugador == null || newJugador == null)
            return null; //si existe lo vamos a actualizr
        else {
            exJugador.setIscaptain(false);
            newJugador.setIscaptain(true);
            jugadorDotaRepository.save(exJugador);
            jugadorDotaRepository.save(newJugador);
        }

        return mapToResponse(newJugador);//retorna el objeto actualizado
    }

    public List<JugadorDotaResponse> listOrdenadaJugadoresDotaPorEquipo() {
        return jugadorDotaRepository.findAllByState(true).stream()
                .sorted(Comparator.comparingInt(player::getEquipo_id))
                .map(jugador -> {
                    return mapToResponse(jugador);
                }).collect(Collectors.toList());

    }

    @Override
    public String deleteLogico(Long id) {
        player jugador = jugadorDotaRepository.findByIdAndState(id, true).orElse(null);
        if (jugador == null)
            return "El Registro no Existe!!";
        jugador.setState(false);//ACtualiza el estado
        jugadorDotaRepository.save(jugador);//Guarda los datos actualizados
        return "Registro Eliminado Lógicamente:  Jugador : " + jugador.getName();
    }

}
