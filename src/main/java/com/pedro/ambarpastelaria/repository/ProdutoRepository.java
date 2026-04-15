package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.Categoria;
import com.pedro.ambarpastelaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto>findByCategoria(Categoria cat);
}
