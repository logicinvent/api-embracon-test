package br.com.embracon.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(nullable = false)
    private LocalDateTime dtHrConsulta;

}
