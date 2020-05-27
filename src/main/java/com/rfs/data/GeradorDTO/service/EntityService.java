package com.rfs.data.GeradorDTO.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

interface EntityService<T> {
    T save(T entityDTO);
    T create(T entityDTO);
    T update(T entityDTO);
    Page<T> findAll(Pageable pageable);
    Optional<T> findOne(Long id);
    void delete(Long id);
}
