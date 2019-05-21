package com.example.SimulacroParcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Candidato {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer cantidadDeVotos;
    private LocalDateTime fecha;

    @PrePersist
    public void setearHora(){
        if(this.fecha==null){
            this.fecha = LocalDateTime.now().plusHours(3).plusMinutes(20);
        }

    }
}
