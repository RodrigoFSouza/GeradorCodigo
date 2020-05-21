package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.ClienteMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ClienteMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    @MockBean
    private TipoAtividadeMapper tipoAtividadeMapper;
    @MockBean
    private EnderecoMapper enderecoMapper;
    @MockBean
    private ContatoMapper contatoMapper;
    @MockBean
    private ContratoMapper contratoMapper;
    @MockBean
    private ContabilMapper contabilMapper;
    @MockBean
    private FormaPagamentoMapper formaPagamentoMapper;
    @MockBean
    private CondicaoPagamentoMapper condicaoPagamentoMapper;
    @MockBean
    private FornecedorMapper fornecedorMapper;

    private ClienteMapper clienteMapper;

    @Before
    public void setUp() {
        clienteMapper = new ClienteMapperImpl(auditoriaMapper, tipoAtividadeMapper, enderecoMapper, contatoMapper, contratoMapper, contabilMapper, formaPagamentoMapper, condicaoPagamentoMapper, fornecedorMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
