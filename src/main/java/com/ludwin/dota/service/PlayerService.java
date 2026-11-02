package com.ludwin.dota.service;

import java.util.List;

import com.ludwin.dota.model.request.PlayerRequest;
import com.ludwin.dota.model.response.PlayerResponse;

public interface PlayerService {

    public List<PlayerResponse> list();
    /* 
    public PlayerResponse createJugadorDota(PlayerRequest request) throws Exception;
    
    public PlayerResponse getJugadorDotaById(Long id);
    
    public PlayerResponse updateAsignateCaptain(Long id);
    
    public PlayerResponse updateJugadorDotaNewCaptain(Long idExCaptain, Long idNewCaptain);
    
    public List<PlayerResponse> listOrdenadaJugadoresDotaPorEquipo();
    
    public String deleteLogico(Long id);
    */
}
