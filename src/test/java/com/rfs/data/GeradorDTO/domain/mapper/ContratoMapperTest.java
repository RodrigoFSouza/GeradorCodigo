package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.ContratoMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@RunWith(SpringRunner.class)
public class ContratoMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    @MockBean
    private ClienteMapper clienteMapper;
    @MockBean
    private IndiceEconomicoMapper indiceEconomicoMapper;

    private ContratoMapper contratoMapper;

    @Before
    public void setUp() {
        contratoMapper = new ContratoMapperImpl(auditoriaMapper, clienteMapper, indiceEconomicoMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
