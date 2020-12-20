package com.stefanini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.domain.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
