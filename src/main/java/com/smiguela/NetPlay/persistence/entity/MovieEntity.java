package com.smiguela.NetPlay.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

// Para marcar el objeto como entidad/tabla para la DB
@Entity
// Como se va a llamar la tabla en la DB
@Table(name="movies")
public class MovieEntity {
    // Para definir que el siguiente atributo es la PK de la tabla
    @Id
    // Para que se genere automaticamente
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    // Definimos nombre y condiciones que se deben cumplir para las columnas de la tabla para la DB
    @Column(nullable=false, length=200, unique=true)
    private String name;
    @Column(nullable=false, precision=600)
    private String description;
    @Column(nullable=false, precision=3)
    private int length;
    @Column(nullable=false, precision=30)
    private String gender;
    @Column(name="premiere_date",precision=30)
    private LocalDate premiereDate;
    // con scale le decimos que maximo dos decimales para la calificacion
    @Column(precision=3, scale=2)
    private BigDecimal classification;
    @Column(nullable=false)
    private Boolean isAvailable;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public BigDecimal getClassification() {
        return classification;
    }

    public void setClassification(BigDecimal classification) {
        this.classification = classification;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Long getId(){
        return this.id;
    }
}
