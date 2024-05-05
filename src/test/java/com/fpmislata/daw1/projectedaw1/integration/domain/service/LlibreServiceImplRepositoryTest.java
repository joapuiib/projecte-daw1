package com.fpmislata.daw1.projectedaw1.integration.domain.service;

import com.fpmislata.daw1.projectedaw1.data.AutorData;
import com.fpmislata.daw1.projectedaw1.data.LlibreData;
import com.fpmislata.daw1.projectedaw1.domain.entity.Autor;
import com.fpmislata.daw1.projectedaw1.domain.entity.Llibre;
import com.fpmislata.daw1.projectedaw1.domain.service.LlibreService;
import com.fpmislata.daw1.projectedaw1.domain.service.impl.LlibreServiceImpl;
import com.fpmislata.daw1.projectedaw1.mock.persistance.dao.EscriuDaoMock;
import com.fpmislata.daw1.projectedaw1.mock.persistance.dao.LlibreDaoMock;
import com.fpmislata.daw1.projectedaw1.persistance.repository.impl.LlibreRepositoryImpl;
import com.fpmislata.daw1.projectedaw1.util.JdbcTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LlibreServiceImplRepositoryTest extends JdbcTest {
    private final LlibreService llibreService = new LlibreServiceImpl(
            new LlibreRepositoryImpl(
                    new LlibreDaoMock(),
                    new EscriuDaoMock()
            )
    );

    private final List<Llibre> llibreList = LlibreData.llibreList;
    private final List<Autor> autorList = AutorData.autorList;

    @Nested
    class FindAll {
        @Test
        void givenAllLlibres_shouldReturnAllLlibres() {
            List<Llibre> result = llibreService.findAll();
            assertEquals(llibreList, result);
        }
    }

    @Nested
    class FindById {
        @Test
        void givenLlibreIsbn_shouldReturnLlibre() {
            Llibre expectedLlibre = llibreList.get(0);
            Llibre result = llibreService.findByIsbn("isbn1");
            assertEquals(expectedLlibre, result);
        }

        @Test
        void givenDifferentLlibreIsbn_shouldReturnDifferentLlibre() {
            Llibre expectedLlibre = llibreList.get(1);
            Llibre result = llibreService.findByIsbn("isbn2");
            assertEquals(expectedLlibre, result);
        }

        @Test
        void givenNonExistentLlibreIsbn_shouldReturnNull() {
            Llibre result = llibreService.findByIsbn("inexistentIsbn");
            assertNull(result);
        }
    }

    @Nested
    class FindLatest {
        @Test
        void givenN0_shouldReturnEmptyList() {
            List<Llibre> result = llibreService.findLatest(0);
            assertEquals(List.of(), result);
        }

        @Test
        void givenN1_shouldReturn1MostRecentLlibres() {
            List<Llibre> result = llibreService.findLatest(1);
            List<Llibre> expected = List.of(llibreList.get(5));
            assertEquals(expected, result);
        }

        @Test
        void givenN2_shouldReturn2MostRecentLlibres() {
            List<Llibre> result = llibreService.findLatest(2);
            List<Llibre> expected = List.of(llibreList.get(5), llibreList.get(4));
            assertEquals(expected, result);
        }
    }

    @Nested
    class FindByAutor {
        @Test
        void givenAutorWithNoLlibres_shouldReturnEmptyList() {
            Autor autor = autorList.get(2);
            List<Llibre> result = llibreService.findByAutor(autor);
            assertEquals(List.of(), result);
        }

        @Test
        void givenAutorWithSingleLlibre_shouldReturnSingleLlibreByAutor() {
            Autor autor = autorList.get(1);
            List<Llibre> result = llibreService.findByAutor(autor);
            List<Llibre> expected = List.of(llibreList.get(2));
            assertEquals(expected, result);
        }

        @Test
        void givenAutorWithMultipleLlibres_shouldReturnMultipleLlibresByAutor() {
            Autor autor = autorList.get(0);
            List<Llibre> result = llibreService.findByAutor(autor);
            List<Llibre> expected = List.of(llibreList.get(1), llibreList.get(2));
            assertEquals(expected, result);
        }
    }
}