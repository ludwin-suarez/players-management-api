package com.example.registerjugadordotaweb.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Data
@Builder // Agregar además siempre @NoArgsConstructor y @AllArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dni", length = 8)
    private String dni;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "iscaptain")
    private boolean iscaptain;
    @Column(name = "description")
    private String description;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "equipo_id")
    private int equipo_id;

    @Column(name = "rol_id")
    private int  rol_id;

}
