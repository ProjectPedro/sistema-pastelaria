package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.model.StatusPedido;
import com.pedro.ambarpastelaria.DTO.PedidoRequestDTO;
import com.pedro.ambarpastelaria.DTO.PedidoResponseDTO;
import com.pedro.ambarpastelaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoResponseDTO salvar(@RequestBody @Valid PedidoRequestDTO dto)
    {
        return pedidoService.salvar(dto);
    }

    @PostMapping("/{id}/repetir")
    public PedidoResponseDTO repetirPedido(@PathVariable Long id)
    {
        return pedidoService.repetirPedido(id);
    }
    @GetMapping
    public List<PedidoResponseDTO> listar()
    {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO buscarPorId(@PathVariable Long id)
    {
        return pedidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoResponseDTO atualizar
            (@PathVariable Long id, @RequestBody @Valid PedidoRequestDTO dto)
    {
        return pedidoService.atualizar(id, dto);
    }

    @PatchMapping("/{id}/status")
    public PedidoResponseDTO atualizarStatus(@PathVariable Long id,@RequestParam StatusPedido status)
    {
        return pedidoService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id)
    {
        pedidoService.deletar(id);
    }
}
