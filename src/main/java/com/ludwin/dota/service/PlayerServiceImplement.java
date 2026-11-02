package com.ludwin.dota.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.ludwin.dota.exception.ResourceNotFoundException;
import com.ludwin.dota.mapper.PlayerMapper;
import com.ludwin.dota.model.domain.Player;
import com.ludwin.dota.model.request.PlayerRequest;
import com.ludwin.dota.model.response.PlayerResponse;
import com.ludwin.dota.repository.PlayerRepository;

import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Para injection de dependencias, trabaja sólo con variables requeridas: tipo final
@Slf4j
public class PlayerServiceImplement implements PlayerService {
    private final PlayerRepository playerRepository;

    //@Transactional(readOnly = true)
    @Override
    public List<PlayerResponse> list() {
        return playerRepository.findAllBy(true).stream().map(PlayerMapper::toMapResponse).toList();
        //.collect(Collectors.toList());
    }

    
    @Transactional(readOnly = true)
    public Page<PlayerResponse> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable).map(PlayerResponse::from);
    }

    @Transactional(readOnly = true)
    public PlayerResponse findById(Long id) {
        return PlayerResponse.from(getEntity(id));
    }

    public PlayerResponse create(PlayerRequest request) {
        if (playerRepository.existsByNicknameIgnoreCase(request.nickname().trim())) {
            throw new IllegalArgumentException("Ya existe un jugador con ese nickname.");
        }
        Player player = new Player(request.nickname().trim(), request.firstName().trim(),
                request.lastName().trim(), request.email(), request.countryCode());
        return PlayerResponse.from(repository.save(player));
    }

    public PlayerResponse update(Long id, PlayerRequest request) {
        Player player = getEntity(id);
        boolean nicknameUsed = repository.existsByNicknameIgnoreCase(request.nickname().trim())
                && !player.getNickname().equalsIgnoreCase(request.nickname().trim());
        if (nicknameUsed) throw new IllegalArgumentException("Ya existe un jugador con ese nickname.");
        player.update(request.nickname().trim(), request.firstName().trim(), request.lastName().trim(),
                request.email(), request.countryCode(), request.active() == null || request.active());
        return PlayerResp
            nse.from(player);
    }

    public void delete(Long id) {
        Player player = getEntity(id);
        // Baja lógica para no romper estadísticas e historial de partidas.
        player.update(player.getNickname(), player.getFirstName(), player.getLastName(),
                player.getEmail(), player.getCountryCode(), false);
    }

    private Player getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el jugador con id " + id));
    }
}
