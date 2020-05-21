package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.ContabilMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ContabilMapperTest {

    @MockBean
    private AuditoriaMapper auditoriaMapper;
    @MockBean
    private ClienteMapper clienteMapper;

    private ContabilMapper contabilMapper;

    @Before
    public void setUp() {
        contabilMapper = new ContabilMapperImpl(auditoriaMapper, clienteMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
