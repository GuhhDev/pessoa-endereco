package com.gustavo.avaliacaoprojetopessoa.repositories;

import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {}
