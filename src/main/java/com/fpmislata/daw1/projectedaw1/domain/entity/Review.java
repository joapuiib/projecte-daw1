package com.fpmislata.daw1.projectedaw1.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private User user;
    private Llibre llibre;
    private String text;
    private int puntuacio;

    public Review(User user, Llibre llibre, String text, int puntuacio) {
        this.user = user;
        this.llibre = llibre;
        this.text = text;
        this.puntuacio = puntuacio;
    }

    public Review() {
    }
}
