package com.fpmislata.daw1.projectedaw1.persistance.repository.impl;

import com.fpmislata.daw1.projectedaw1.domain.entity.Autor;
import com.fpmislata.daw1.projectedaw1.persistance.dao.AutorDao;
import com.fpmislata.daw1.projectedaw1.persistance.repository.AutorRepository;

import java.util.List;

public class AutorRepositoryImpl implements AutorRepository {
    private final AutorDao autorDao;

    public AutorRepositoryImpl(AutorDao autorDao) {
        this.autorDao = autorDao;
    }

    @Override
    public Autor findById(int id) {
        return autorDao.findById(id);
    }

    @Override
    public List<Autor> findAll() {
        return autorDao.findAll();
    }
}