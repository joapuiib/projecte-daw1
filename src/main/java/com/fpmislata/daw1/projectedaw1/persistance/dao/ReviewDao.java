package com.fpmislata.daw1.projectedaw1.persistance.dao;

import com.fpmislata.daw1.projectedaw1.domain.entity.Review;

import java.util.List;

public interface ReviewDao {
    Review findByLlibreIsbnAndUsername(String isbn, String username);
    List<Review> findByLlibreIsbn(String isbn);
    List<Review> findByUsername(String username);
}
