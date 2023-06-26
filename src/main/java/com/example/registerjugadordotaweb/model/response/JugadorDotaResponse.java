package com.example.registerjugadordotaweb.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JugadorDotaResponse {

    private long id;
    private String dni;
    private String name;
    private String lastname;
    private int age;
    private boolean iscaptain;
    private String description;
    private Boolean state;
    private int equipo_id;
    private int  rol_id;
}
