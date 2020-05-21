package com.rfs.data.GeradorDTO.domain.mapper;

import com.rfs.data.GeradorDTO.domain.mapper.implementation.IndiceEconomicoMapperImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class IndiceEconomicoMapperTest {
    @MockBean
    private AuditoriaMapper auditoriaMapper;

    private IndiceEconomicoMapper indiceEconomicoMapper;

    @Before
    public void setUp() {
        indiceEconomicoMapper = new IndiceEconomicoMapperImpl(auditoriaMapper);
    }

    @Test
    public void testEntityFromId() {

    }
}
