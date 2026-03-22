package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
