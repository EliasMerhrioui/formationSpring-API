package com.postgresql.formationSpring.dto;

import lombok.Data;

@Data
public class PlayerDTO {
    private String name;
    private String email;
    private int jerseyNumber;
    private String position;
    private String team;
}