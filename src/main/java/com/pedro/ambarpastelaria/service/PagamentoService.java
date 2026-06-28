package com.pedro.ambarpastelaria.service;

import com.pedro.ambarpastelaria.DTO.PagamentoRequestDTO;
import com.pedro.ambarpastelaria.DTO.PagamentoResponseDTO;
import com.pedro.ambarpastelaria.exception.PedidoNaoEncontradoException;
import com.pedro.ambarpastelaria.model.Pagamento;
import com.pedro.ambarpastelaria.model.Pedido;
import com.pedro.ambarpastelaria.model.StatusPedido;
import com.pedro.ambarpastelaria.repository.PagamentoRepository;
import com.pedro.ambarpastelaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    private PagamentoResponseDTO converterParaDTO(Pagamento pagamento)
    {
        PagamentoResponseDTO dto = new PagamentoResponseDTO();
        dto.setId(pagamento.getId());
        dto.setPedidoId(pagamento.getPedido().getId());
        dto.setValor(pagamento.getValor());
        dto.setFormaPagamento(pagamento.getFormaPagamento());
        dto.setDataPagamento(pagamento.getDataPagamento());
        dto.setAprovado(pagamento.getAprovado());
        return dto;
    }

    public PagamentoResponseDTO pagar (PagamentoRequestDTO request)
    {
        Pedido pedido = pedidoRepository.findById(request.getPedidoId())
                .orElseThrow(() -> new PedidoNaoEncontradoException(request.getPedidoId()));

        if (pagamentoRepository.findByPedidoId(pedido.getId()).isPresent()) {
            throw new RuntimeException("Esse Pedido já foi pago!");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setValor(pedido.getTotal());
        pagamento.setFormaPagamento(request.getFormaPagamento());
        pagamento.setDataPagamento(LocalDateTime.now());
        pagamento.setAprovado(true);

        pedido.setStatus(StatusPedido.FINALIZADO);
        pedidoRepository.save(pedido);

        return converterParaDTO(pagamentoRepository.save(pagamento));
    }

    public PagamentoResponseDTO buscarPorPedido(Long pedidoId)
    {
        Pagamento pagamento = pagamentoRepository.findByPedidoId(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pagamento Não encontrado para esse pedido"));
        return converterParaDTO(pagamento);
    }

    public List<PagamentoResponseDTO>listar()
    {
        return pagamentoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }
}
