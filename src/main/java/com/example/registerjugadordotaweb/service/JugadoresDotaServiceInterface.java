package com.example.registerjugadordotaweb.service;

import com.example.registerjugadordotaweb.model.request.JugadorDotaRequest;
import com.example.registerjugadordotaweb.model.response.JugadorDotaResponse;

import java.util.List;

public interface JugadoresDotaServiceInterface {

    public List<JugadorDotaResponse> list();
    public JugadorDotaResponse createJugadorDota(JugadorDotaRequest request)throws Exception;
    public JugadorDotaResponse getJugadorDotaById(Long id);
    public JugadorDotaResponse updateAsignateCaptain(Long id);
    public JugadorDotaResponse updateJugadorDotaNewCaptain(Long idExCaptain,Long idNewCaptain);
    public List<JugadorDotaResponse> listOrdenadaJugadoresDotaPorEquipo();
    public String deleteLogico(Long id);
}
