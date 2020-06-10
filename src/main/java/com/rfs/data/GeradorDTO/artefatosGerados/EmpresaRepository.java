package com.rfs.data.GeradorDTO.repository;

import com.rfs.data.GeradorDTO.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {
    @Query(value = "SELECT MAX(e.id) FROM Empresa e")
    Optional<Long> getUltimoId();
}

