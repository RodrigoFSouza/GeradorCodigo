package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.FormaPagamentoMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class FormaPagamentoMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    private FormaPagamentoMapper formaPagamentoMapper;

    @Before
    public void setUp() {
        formaPagamentoMapper = new FormaPagamentoMapperImpl(auditoriaMapper);
    }


    @Test
    public void testEntityFromId() {

    }
}
