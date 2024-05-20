package com.fpmislata.daw1.projectedaw1.integration.domain.service;

import com.fpmislata.daw1.projectedaw1.data.UsuariData;
import com.fpmislata.daw1.projectedaw1.domain.entity.Usuari;
import com.fpmislata.daw1.projectedaw1.domain.service.UsuariService;
import com.fpmislata.daw1.projectedaw1.domain.service.impl.UsuariServiceImpl;
import com.fpmislata.daw1.projectedaw1.persistance.dao.impl.memory.UsuariDaoMemory;
import com.fpmislata.daw1.projectedaw1.persistance.dao.impl.memory.data.UsuariTableMemory;
import com.fpmislata.daw1.projectedaw1.persistance.repository.impl.UsuariRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuariServiceImplMemoryDaoTest {
    private final UsuariTableMemory usuariTableMemory = Mockito.mock(UsuariTableMemory.class);

    private final UsuariService usuariService = new UsuariServiceImpl(
            new UsuariRepositoryImpl(
                    new UsuariDaoMemory(usuariTableMemory)
            )
    );

    private final List<Usuari> Usuari_LIST = UsuariData.USUARI_LIST;

    @BeforeEach
    void setup() {
        when(usuariTableMemory.get()).thenReturn(UsuariData.USER_RECORD_LIST);
    }

    @Nested
    class FindByUsername {
        @Test
        void givenUsername_shouldReturnUser() {
            Usuari expectedUsuari = Usuari_LIST.get(0);
            Usuari result = usuariService.findByUsername("user1");
            assertEquals(expectedUsuari, result);
        }

        @Test
        void givenDifferentUsername_shouldReturnDifferentUser() {
            Usuari expectedUsuari = Usuari_LIST.get(1);
            Usuari result = usuariService.findByUsername("user2");
            assertEquals(expectedUsuari, result);
        }

        @Test
        void givenNonExistentUsername_shouldReturnNull() {
            Usuari result = usuariService.findByUsername("nonExistentUsername");
            assertNull(result);
        }
    }

    @Nested
    class FindByEmail {
        @Test
        void givenEmail_shouldReturnUser() {
            Usuari expectedUsuari = Usuari_LIST.get(0);
            Usuari result = usuariService.findByEmail("user1@localhost");
            assertEquals(expectedUsuari, result);
        }

        @Test
        void givenDifferentEmail_shouldReturnDifferentUser() {
            Usuari expectedUsuari = Usuari_LIST.get(1);
            Usuari result = usuariService.findByEmail("user2@localhost");
            assertEquals(expectedUsuari, result);
        }

        @Test
        void givenNonExistentEmail_shouldReturnNull() {
            Usuari result = usuariService.findByEmail("nonExistentEmail");
            assertNull(result);
        }
    }

}