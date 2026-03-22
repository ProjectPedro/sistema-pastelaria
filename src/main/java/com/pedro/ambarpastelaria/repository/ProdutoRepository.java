package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<produto, Long> {

}
