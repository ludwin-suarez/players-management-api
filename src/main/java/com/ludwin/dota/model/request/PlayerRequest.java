package com.ludwin.dota.model.request;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class PlayerRequest {

    @Size(min = 8, max = 8, message = "EL CAMPO CÓDIGO DEBE TENER 8 CARACTERES")
    @NotBlank(message = "EL CAMPO CÓDIGO NO DEBE ESTAR EN BLANCO")
    private String code;

    @NotBlank(message = "EL CAMPO APODO NO DEBE ESTAR EN BLANCO")
    @Size(max = 40)
    private String nickName;

    @NotBlank(message = "EL CAMPO NOMBRE NO DEBE ESTAR EN BLANCO")
    @Size(max = 80)
    private String firstName;

    @NotBlank(message = "EL CAMPO APELLIDOS NO PUEDE QUEDAR EN BLANCO")
    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "EL CAMPO EDAD NO PUEDE QUEDAR EN BLANCO")
    @NotNull(message = "EL CAMPO EDAD NO PUEDE SER NULO")
    @Digits(integer = 2, fraction = 0, message = "LA EDAD DEBE SER UN NUMERO ENTERO SIN DECIMALES")
    @Size(max = 2, message = "LA EDAD NO DEBE EXCEDER DE 99 AÑOS")
    private int age;

    @NotBlank(message = "EL CAMPO CORREO NO PUEDE SER NULO")
    @Size(max = 160, message = "CORREO NO DEBE EXCEDER 160 CARACTERES")
    private String email;

    @Size(min = 2, max = 2, message = "EL CÓDIGO DE CADA PAIS NO EXCEDE DE 2 NUMEROS")
    private String countryCode;

    @NotNull(message = "EL CAMPO ESTADO NO PUEDE SER NULO")
    @NotBlank(message = "EL CAMPO ESTADO NO PUEDE QUEDAR EN BLANCO")
    @Size(max = 1)
    private Boolean state;// verificar con que si se ingresa automatico

}
