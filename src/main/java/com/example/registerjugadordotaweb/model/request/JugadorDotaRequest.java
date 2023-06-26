package com.example.registerjugadordotaweb.model.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class JugadorDotaRequest {

    @NotNull(message = "El campo DNI no debe ser nulo")
    @Size(min = 8, max = 8, message = "El DNI debe tener un tamaño fijo de 8 caracteres")
    @NotBlank(message = "DNI no debe estar en blanco")
    @Pattern(regexp = "\\d*", message = "El DNI debe estar formado por sólo números")
    private String dni;

    @NotNull(message = "El campo Nombre no debe ser nulo")
    @NotEmpty
    @NotBlank(message = "EL CAMPO name NO PUEDE QUEDAR EN BLANCO")
    @Size(max = 70)
    private String name;

    @NotNull(message = "El campo Apellidos no debe ser nulo")
    @NotEmpty @NotBlank(message = "EL CAMPO lastname NO PUEDE QUEDAR EN BLANCO")
    @Size(max = 70)
    private String lastname;
    @NotNull(message = "EL CAMPO EDAD NO PUEDE SER NULO")
    private int age;
    @NotNull(message = "EL CAMPO iscaptain NO PUEDE SER NULO")
    @NotBlank(message = "EL CAMPO iscaptain NO PUEDE QUEDAR EN BLANCO")
    private boolean iscaptain;
    @NotNull(message = "EL CAMPO description NO PUEDE SER NULO")
    private String description;
    @NotNull(message = "EL CAMPO state NO PUEDE SER NULO")
    @NotBlank(message = "EL CAMPO state NO PUEDE QUEDAR EN BLANCO")
    private Boolean state;
    @NotNull(message = "EL CAMPO equipo_id NO PUEDE SER NULO")
    @NotBlank(message = "EL CAMPO equipo_id NO PUEDE QUEDAR EN BLANCO")
    private int equipo_id;
    @NotNull(message = "EL CAMPO rol_id NO PUEDE SER NULO")
    @NotBlank(message = "EL CAMPO rol_id NO PUEDE QUEDAR EN BLANCO")
    private int  rol_id;
}
