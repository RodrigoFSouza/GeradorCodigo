package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.RegiaoMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RegiaoMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;
    private RegiaoMapper regiaoMapper;

    @Before
    public void setUp() {
        regiaoMapper = new RegiaoMapperImpl(auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
