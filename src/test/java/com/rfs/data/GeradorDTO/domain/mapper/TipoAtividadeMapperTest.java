package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.TipoAtividadeMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class TipoAtividadeMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;

    private TipoAtividadeMapper tipoAtividadeMapper;

    @Before
    public void setUp() {
        tipoAtividadeMapper = new TipoAtividadeMapperImpl(auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
