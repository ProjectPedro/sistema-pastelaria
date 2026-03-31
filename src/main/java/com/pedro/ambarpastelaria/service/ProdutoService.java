package com.pedro.ambarpastelaria.service;

import com.pedro.ambarpastelaria.DTO.ProdutoDTO;
import com.pedro.ambarpastelaria.model.Produto;
import com.pedro.ambarpastelaria.model.Categoria;
import com.pedro.ambarpastelaria.exception.ProdutoNaoEncontradoException;
import com.pedro.ambarpastelaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService{
    @Autowired
    private ProdutoRepository repository;

    private ProdutoDTO converterParaDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();

        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setDescricao(produto.getDescricao());
        dto.setCategoria(produto.getCategoria().name());

        return dto;
    }

    private Produto converterParaProduto(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(Categoria.valueOf(dto.getCategoria().toUpperCase()));
        return produto;
    }

    public ProdutoDTO salvar(ProdutoDTO dto){
        Produto produto = converterParaProduto(dto);
        return converterParaDTO(repository.save(produto));
    }

    public List<ProdutoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }
    public ProdutoDTO buscaPorId(Long id){
        Produto produto = repository.findById(id).orElseThrow(()-> new ProdutoNaoEncontradoException(id));
        return converterParaDTO(produto);
    }
    public ProdutoDTO atualizar(Long id, ProdutoDTO dto){
        Produto produto = repository.findById(id).orElseThrow(()-> new ProdutoNaoEncontradoException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(Categoria.valueOf(dto.getCategoria().toUpperCase()));
        return converterParaDTO(repository.save(produto));
    }
    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new ProdutoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }
}
