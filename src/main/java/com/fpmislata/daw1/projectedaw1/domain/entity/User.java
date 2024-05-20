package com.fpmislata.daw1.projectedaw1.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class User {
    private String username;
    private String email;
    private LocalDate dataRegistre;
    private String hashedPassword;

    private List<Rol> roles;

    public User(String username, String email, LocalDate dataRegistre) {
        this.username = username;
        this.email = email;
        this.dataRegistre = dataRegistre;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(dataRegistre, user.dataRegistre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, dataRegistre);
    }
}
