package com.ludwin.dota.mapper;

import com.ludwin.dota.model.domain.Player;
import com.ludwin.dota.model.response.PlayerResponse;

public class PlayerMapper {

    private PlayerMapper() {
        // Evita crear instancias de esta clase
    }

    public static PlayerResponse toMapResponse(Player jugador) {
        return PlayerResponse.builder()
                .id(jugador.getId())
                .code(jugador.getCode())
                .nickName(jugador.getNickName())
                .firstName(jugador.getFirstName())
                .lastName(jugador.getLastName())
                .age(jugador.getAge())
                .email(jugador.getEmail())
                .countryCode(jugador.getCountryCode())
                .active(jugador.isActive())
                .createdAt(jugador.getCreatedAt())
                .updatedAt(jugador.getUpdatedAt())
                .build();
    }

}
