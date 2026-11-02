package com.ludwin.dota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.ludwin.dota.model.domain.Player;
import java.util.List;
import java.util.Optional;

//@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllBy(Boolean state);

    Optional<Player> findByIdAndState(Long id, Boolean state);

    boolean exiexistsByNickNameIgnoreCase(String nickName);

}
