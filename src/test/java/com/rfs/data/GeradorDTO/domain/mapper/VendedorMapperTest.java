package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.VendedorMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VendedorMapperTest {
    @MockBean
    private FornecedorMapper fornecedorMapper;
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    @MockBean
    private EnderecoMapper enderecoMapper;

    private VendedorMapper vendedorMapper;

    @BeforeEach
    public void setUp() {
        vendedorMapper = new VendedorMapperImpl(fornecedorMapper, auditoriaMapper, enderecoMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
