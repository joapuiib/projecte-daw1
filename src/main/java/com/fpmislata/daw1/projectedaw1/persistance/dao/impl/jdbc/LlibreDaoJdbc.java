package com.fpmislata.daw1.projectedaw1.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.projectedaw1.domain.entity.Llibre;
import com.fpmislata.daw1.projectedaw1.persistance.dao.LlibreDao;
import com.fpmislata.daw1.projectedaw1.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.projectedaw1.persistance.dao.impl.jdbc.rowmapper.LlibreRowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LlibreDaoJdbc implements LlibreDao {

    private final DatabaseConnection databaseConnection;
    private final LlibreRowMapper llibreRowMapper;
    public LlibreDaoJdbc() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.llibreRowMapper = new LlibreRowMapper();
    }
    @Override
    public List<Llibre> findAll() {
        String sql = "SELECT * FROM llibre";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            return llibreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Llibre findByIsbn(String isbn) {
        String sql = "SELECT * FROM llibre where isbn = ?";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, isbn);
            ResultSet rs = preparedStatement.executeQuery();
            List<Llibre> llibreList = llibreRowMapper.map(rs);
            return llibreList.isEmpty() ? null : llibreList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Llibre> findLatest(int n) {
        String sql = "SELECT * FROM llibre order by data_publicacio desc limit ?";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, n);
            ResultSet rs = preparedStatement.executeQuery();
            return llibreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Llibre> findMostRead(int n) {
        throw new UnsupportedOperationException("LlibreDaoJdbc::findMostRead no s'ha implementat encara");
    }

    @Override
    public List<Llibre> findBestReview(int n) {
        throw new UnsupportedOperationException("LlibreDaoJdbc::findBestReview no s'ha implementat encara");
    }

    @Override
    public boolean insert(Llibre llibre) {
        throw new UnsupportedOperationException("LlibreDaoJdbc::insert no s'ha implementat encara");
    }

    @Override
    public Llibre delete(String isbn) {
        throw new UnsupportedOperationException("LlibreDaoJdbc::delete no s'ha implementat encara");
    }
}
