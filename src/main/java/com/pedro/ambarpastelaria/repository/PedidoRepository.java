package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
