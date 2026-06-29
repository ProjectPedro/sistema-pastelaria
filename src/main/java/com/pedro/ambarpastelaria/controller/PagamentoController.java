package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.DTO.PagamentoRequestDTO;
import com.pedro.ambarpastelaria.DTO.PagamentoResponseDTO;
import com.pedro.ambarpastelaria.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public PagamentoResponseDTO pagar(@RequestBody @Valid PagamentoRequestDTO dto)
    {
        return pagamentoService.pagar(dto);
    }

    @GetMapping("/pedido/{pedidoId}")
    public PagamentoResponseDTO buscarPorPedido(@PathVariable Long pedidoId)
    {
        return pagamentoService.buscarPorPedido(pedidoId);
    }

    @GetMapping
    public List<PagamentoResponseDTO> listar()
    {
        return pagamentoService.listar();
    }
}
