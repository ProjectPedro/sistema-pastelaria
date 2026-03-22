package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.model.Produto;
import com.pedro.ambarpastelaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController
{
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto salvar(@RequestBody Produto p)
    {
        return repository.save(p);
    }
    @GetMapping
    public List<Produto> listar()
    {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id)
    {
        return repository.findById(id).orElse(null);
    }
}
