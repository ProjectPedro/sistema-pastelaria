package com.pedro.ambarpastelaria.repository;

import com.pedro.ambarpastelaria.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends  JpaRepository<ItemPedido,Long> {
}
