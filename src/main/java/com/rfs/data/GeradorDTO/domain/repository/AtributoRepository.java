package com.rfs.data.GeradorDTO.domain.repository;

import com.rfs.data.GeradorDTO.domain.model.Atributo;
import com.rfs.data.GeradorDTO.domain.model.Entidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Long> {
    Page<Atributo> findByEntidade(Entidade entidade, Pageable pageable);
}
