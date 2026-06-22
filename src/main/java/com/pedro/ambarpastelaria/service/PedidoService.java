package com.pedro.ambarpastelaria.service;

import com.pedro.ambarpastelaria.DTO.ItemPedidoDTO;
import com.pedro.ambarpastelaria.DTO.PedidoRequestDTO;
import com.pedro.ambarpastelaria.DTO.PedidoResponseDTO;
import com.pedro.ambarpastelaria.exception.ProdutoNaoEncontradoException;
import com.pedro.ambarpastelaria.exception.PedidoNaoEncontradoException;
import com.pedro.ambarpastelaria.model.ItemPedido;
import com.pedro.ambarpastelaria.model.Pedido;
import com.pedro.ambarpastelaria.model.Produto;
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

    public PedidoResponseDTO salvar(PedidoRequestDTO request)
    {
        Pedido pedido = new Pedido();
        pedido.setObservacao(request.getObservacao());
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(0.0);

        Pedido pedidoSalvo = repository.save(pedido);
        if (request.getItens() != null) {
            for (ItemPedidoDTO itemDTO : request.getItens())
            {
                Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                        .orElseThrow(() -> new ProdutoNaoEncontradoException(itemDTO.getProdutoId()));

                ItemPedido item = new ItemPedido();
                item.setPedido(pedidoSalvo);
                item.setProduto(produto);
                item.setQuantidade(itemDTO.getQuantidade());
                item.setPrecoUnitario(produto.getPreco());

                itemPedidoRepository.save(item);

                pedidoSalvo.getItens().add(item);
            }
        }
        pedidoSalvo.setTotal(calcularTotal(pedidoSalvo));
        repository.save(pedidoSalvo);
        return converterParaDTO(pedidoSalvo);
    }

    public List<PedidoResponseDTO> listar()
    {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public PedidoResponseDTO buscarPorId(Long id)
    {
        Pedido pedido = repository.findById(id)
                .orElseThrow(()->new PedidoNaoEncontradoException(id));
        return converterParaDTO(pedido);
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO request)
    {
        Pedido pedido = repository.findById(id)
                        .orElseThrow(()->new PedidoNaoEncontradoException(id));

        pedido.setObservacao(request.getObservacao());
        return converterParaDTO(repository.save(pedido));

    }

    public void deletar(Long id)
    {
        if(!repository.existsById(id))
        {
            throw new PedidoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }

}
