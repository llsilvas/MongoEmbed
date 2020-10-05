package com.example.mongdb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
public class Usuario {

    private Long id;
    private String nome;

}
