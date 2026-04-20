package com.pedro.ambarpastelaria.service;

import com.pedro.ambarpastelaria.exception.ProdutoNaoEncontradoException;
import com.pedro.ambarpastelaria.model.Pedido;
import com.pedro.ambarpastelaria.repository.PedidoRepository;
import com.pedro.ambarpastelaria.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido salvar(Pedido pedido)
    {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataPedido(LocalDateTime.now());
        return repository.save(pedido);
    }

    public List<Pedido>listar()
    {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id)
    {
        return repository.findById(id).orElseThrow(()->new ProdutoNaoEncontradoException(id));
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado)
    {
        Pedido pedido = buscarPorId(id);

        pedido.setObservacao(pedidoAtualizado.getObservacao());
        pedido.setStatus(pedidoAtualizado.getStatus());

        return repository.save(pedido);
    }

    public void deletar(Long id)
    {
        if(!repository.existsById(id))
        {throw new ProdutoNaoEncontradoException(id);}
        repository.deleteById(id);
    }

}
