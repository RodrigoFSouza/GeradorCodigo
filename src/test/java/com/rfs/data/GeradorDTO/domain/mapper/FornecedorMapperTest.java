package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.FornecedorMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class FornecedorMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    @MockBean
    private EnderecoMapper enderecoMapper;
    @MockBean
    private TipoAtividadeMapper tipoAtividadeMapper;

    private FornecedorMapper fornecedorMapper;

    @Before
    public void setUp() {
        fornecedorMapper = new FornecedorMapperImpl(auditoriaMapper, enderecoMapper, tipoAtividadeMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
