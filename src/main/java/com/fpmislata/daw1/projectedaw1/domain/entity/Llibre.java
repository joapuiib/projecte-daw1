package com.fpmislata.daw1.projectedaw1.domain.entity;

import com.fpmislata.daw1.projectedaw1.common.container.AutorIoc;
import com.fpmislata.daw1.projectedaw1.domain.service.AutorService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Llibre {
    private String isbn;
    private String titol;
    private String resum;
    private LocalDate dataPublicacio;
    private int nombrePagines;
    private String rutaImatge;

    private List<Autor> autors;
    private List<Genere> generes;

    public Llibre() {
    }

    public Llibre(String isbn, String titol){
        this.isbn = isbn;
        this.titol = titol;
    }

    public Llibre(String isbn, String titol, String resum, LocalDate dataPublicacio, int nombrePagines, String rutaImatge) {
        this.isbn = isbn;
        this.titol = titol;
        this.resum = resum;
        this.dataPublicacio = dataPublicacio;
        this.nombrePagines = nombrePagines;
        this.rutaImatge = rutaImatge;
    }

    public String getPrettyDataPublicacio() {
        return dataPublicacio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public List<Autor> getAutors() {
        if (autors == null) {
            AutorService autorService = AutorIoc.createService();
            autors = autorService.findByLlibre(this);
        }
        return autors;
    }

    public void addAutor(Autor autor) {
        autors.add(autor);
    }

    public List<Genere> getGeneres() {
        return generes;
    }

    public void addGenere(Genere genere) {
        generes.add(genere);
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "isbn='" + isbn + '\'' +
                ", titol='" + titol + '\'' +
                ", data_publicacio='" + dataPublicacio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llibre llibre = (Llibre) o;
        return nombrePagines == llibre.nombrePagines
                && Objects.equals(isbn, llibre.isbn)
                && Objects.equals(titol, llibre.titol)
                && Objects.equals(resum, llibre.resum)
                && Objects.equals(dataPublicacio, llibre.dataPublicacio)
                && Objects.equals(autors, llibre.autors)
                && Objects.equals(generes, llibre.generes);
    }
}
