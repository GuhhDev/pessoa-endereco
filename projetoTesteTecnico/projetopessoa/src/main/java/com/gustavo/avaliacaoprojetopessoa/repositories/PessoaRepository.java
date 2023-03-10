package com.gustavo.avaliacaoprojetopessoa.repositories;

import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
