package com.ludwin.dota.model.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDotaResponse {

    private long id;
    private String code;
    private String nickName;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String countryCode;
    private boolean state;
    private Instant createdAt;
    private Instant updatedAt;

}
