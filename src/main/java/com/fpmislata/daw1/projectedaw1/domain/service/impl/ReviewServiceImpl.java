package com.fpmislata.daw1.projectedaw1.domain.service.impl;

import com.fpmislata.daw1.projectedaw1.domain.entity.Llibre;
import com.fpmislata.daw1.projectedaw1.domain.entity.Review;
import com.fpmislata.daw1.projectedaw1.domain.entity.User;
import com.fpmislata.daw1.projectedaw1.domain.service.ReviewService;
import com.fpmislata.daw1.projectedaw1.persistance.repository.ReviewRepository;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findByLlibreAndUser(Llibre llibre, User user) {
        return null;
    }

    @Override
    public List<Review> findByLlibre(Llibre llibre) {
        return null;
    }

    @Override
    public List<Review> findByUser(User user) {
        return null;
    }
}
