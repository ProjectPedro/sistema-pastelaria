package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.model.Pedido;
import com.pedro.ambarpastelaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido)
    {
        return pedidoService.salvar(pedido);
    }

    @GetMapping
    public List<Pedido> listar()
    {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id)
    {
        return pedidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido)
    {
        return pedidoService.atualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id)
    {
        pedidoService.deletar(id);
    }
}
