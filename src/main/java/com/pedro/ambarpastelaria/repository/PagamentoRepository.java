package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>
{
    Optional<Pagamento>findByPedidoId(Long pedidoId);
}
