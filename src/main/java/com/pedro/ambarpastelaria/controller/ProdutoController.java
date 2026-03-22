package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.model.produto;
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
    public produto salvar(@RequestBody produto p)
    {
        return repository.save(p);
    }
    @GetMapping
    public List<produto> listar()
    {
        return repository.findAll();
    }
}
