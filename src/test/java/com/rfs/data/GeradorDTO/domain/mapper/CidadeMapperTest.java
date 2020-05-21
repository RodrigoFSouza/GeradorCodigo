package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.CidadeMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CidadeMapperTest {

    @MockBean
    private RegiaoMapper regiaoMapper;

    @MockBean
    private AuditoriaMapper auditoriaMapper;

    @MockBean
    private EstadoMapper estadoMapper;

    private CidadeMapper cidadeMapper;

    @Before
    public void setUp() {
        cidadeMapper = new CidadeMapperImpl(auditoriaMapper, estadoMapper, regiaoMapper);
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(cidadeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(cidadeMapper.fromId(null)).isNull();
    }
}
