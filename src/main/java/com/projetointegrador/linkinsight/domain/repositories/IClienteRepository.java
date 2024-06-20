package com.projetointegrador.linkinsight.domain.repositories;

import com.projetointegrador.linkinsight.domain.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
