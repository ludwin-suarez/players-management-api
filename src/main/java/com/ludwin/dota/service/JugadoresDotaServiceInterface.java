package com.ludwin.dota.service;

import java.util.List;

import com.ludwin.dota.model.request.JugadorDotaRequest;
import com.ludwin.dota.model.response.JugadorDotaResponse;

public interface JugadoresDotaServiceInterface {

    public List<JugadorDotaResponse> list();

    public JugadorDotaResponse createJugadorDota(JugadorDotaRequest request) throws Exception;

    public JugadorDotaResponse getJugadorDotaById(Long id);

    public JugadorDotaResponse updateAsignateCaptain(Long id);

    public JugadorDotaResponse updateJugadorDotaNewCaptain(Long idExCaptain, Long idNewCaptain);

    public List<JugadorDotaResponse> listOrdenadaJugadoresDotaPorEquipo();

    public String deleteLogico(Long id);
}
