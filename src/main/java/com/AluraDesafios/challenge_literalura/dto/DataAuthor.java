package com.AluraDesafios.challenge_literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(

        @JsonAlias("name") String nombre,

        @JsonAlias("birth_year") int anioNacimiento,

        @JsonAlias("death_year") int anioMuerte
){

}

