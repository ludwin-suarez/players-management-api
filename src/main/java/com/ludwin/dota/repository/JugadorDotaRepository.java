package com.ludwin.dota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.ludwin.dota.model.domain.player;

import java.util.List;
import java.util.Optional;

//@Repository
public interface JugadorDotaRepository extends JpaRepository<player, Long> {
    List<player> findAllByState(Boolean state);

    Optional<player> findByIdAndState(Long id, Boolean state);

    boolean exiexistsByNickNameIgnoreCase(String nickName);

}
