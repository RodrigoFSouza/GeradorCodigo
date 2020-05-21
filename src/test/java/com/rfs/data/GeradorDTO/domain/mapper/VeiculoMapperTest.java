package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.VeiculoMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class VeiculoMapperTest {
    @MockBean
    private CidadeMapper cidadeMapper;
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    private VeiculoMapper veiculoMapper;

    @BeforeEach
    public void setUp() {
        veiculoMapper = new VeiculoMapperImpl(cidadeMapper, auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
