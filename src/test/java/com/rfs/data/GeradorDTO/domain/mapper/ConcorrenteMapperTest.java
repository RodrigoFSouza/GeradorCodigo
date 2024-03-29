package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.ConcorrenteMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ConcorrenteMapperTest {

    @MockBean
    private AuditoriaMapper auditoriaMapper;

    private ConcorrenteMapper concorrenteMapper;

    @Before
    public void setUp() {
        concorrenteMapper = new ConcorrenteMapperImpl(auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
