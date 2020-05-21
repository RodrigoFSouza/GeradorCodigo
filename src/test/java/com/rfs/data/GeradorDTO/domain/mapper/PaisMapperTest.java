package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.PaisMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PaisMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    private PaisMapper paisMapper;

    @Before
    public void setUp() {
        paisMapper = new PaisMapperImpl(auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
