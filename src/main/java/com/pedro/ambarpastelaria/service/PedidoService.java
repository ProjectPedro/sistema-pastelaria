package com.pedro.ambarpastelaria.service;

import com.pedro.ambarpastelaria.DTO.ItemPedidoDTO;
import com.pedro.ambarpastelaria.DTO.PedidoResponseDTO;
import com.pedro.ambarpastelaria.exception.ProdutoNaoEncontradoException;
import com.pedro.ambarpastelaria.exception.PedidoNaoEncontradoException;
import com.pedro.ambarpastelaria.model.ItemPedido;
import com.pedro.ambarpastelaria.model.Pedido;
import com.pedro.ambarpastelaria.repository.PedidoRepository;
import com.pedro.ambarpastelaria.repository.ItemPedidoRepository;
import com.pedro.ambarpastelaria.repository.ProdutoRepository;
import com.pedro.ambarpastelaria.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    private ItemPedidoDTO converterItemParaDTO(ItemPedido item)
    {
        ItemPedidoDTO dto = new ItemPedidoDTO();
        dto.setProdutoId(item.getProduto().getId());
        dto.setQuantidade(item.getQuantidade());
        return dto;
    }

    private PedidoResponseDTO converterParaDTO(Pedido pedido)
    {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(pedido.getId());
        dto.setObservacao(pedido.getObservacao());
        dto.setStatusPedido(pedido.getStatus());
        dto.setTotal(pedido.getTotal());
        dto.setDataPedido(pedido.getDataPedido());

        List<ItemPedidoDTO> itensDTO = pedido.getItens()
                .stream()
                .map(this::converterItemParaDTO)
                .toList();
        dto.setItens(itensDTO);

        return dto;
    }

    public Double calcularTotal(Pedido pedido)
    {
        double total = 0.0;
        for(ItemPedido item : pedido.getItens())
        {
            total += item.getQuantidade() * item.getPrecoUnitario();
        }
        return total;
    }

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
        return repository.findById(id).orElseThrow(()->new PedidoNaoEncontradoException(id));
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
