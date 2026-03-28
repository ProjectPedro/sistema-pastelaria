package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.DTO.ProdutoDTO;
import com.pedro.ambarpastelaria.model.Categoria;
import com.pedro.ambarpastelaria.model.Produto;
import com.pedro.ambarpastelaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController
{
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

    @PostMapping
    public ProdutoDTO salvar(@RequestBody @Valid ProdutoDTO dto)
    {
        Produto produto = new Produto();


        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(Categoria.valueOf(dto.getCategoria().toUpperCase()));

        Produto salvo = repository.save(produto);
        return converterParaDTO(salvo);
    }
    @GetMapping
    public List<ProdutoDTO> listar()
    {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }
    @GetMapping("/{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id)
    {
        Produto produto = repository.findById(id).orElse(null);

        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        return converterParaDTO(produto);
    }

    /*Metodo para atualizar produto. */
    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dto)
    {
        Produto produto = repository.findById(id).orElse(null);

        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(Categoria.valueOf(dto.getCategoria().toUpperCase()));
        Produto atualizado = repository.save(produto);
        return converterParaDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }
}
