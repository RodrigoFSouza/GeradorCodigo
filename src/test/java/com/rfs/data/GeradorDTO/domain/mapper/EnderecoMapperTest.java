package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.EnderecoMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.useDefaultDateFormatsOnly;

@RunWith(SpringRunner.class)
public class EnderecoMapperTest {
    @MockBean
    private CidadeMapper mapperCidade;
    @MockBean
    private ClienteMapper clienteMapper;
    @MockBean
    private FornecedorMapper fornecedorMapper;
    @MockBean
    private VendedorMapper vendedorMapper;
    @MockBean
    private AuditoriaMapper auditoriaMapper;

    private EnderecoMapper enderecoMapper;

    @Before
    public void setUp() {
        enderecoMapper = new EnderecoMapperImpl(mapperCidade, clienteMapper, fornecedorMapper, vendedorMapper, auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
