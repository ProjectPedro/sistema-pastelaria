package com.pedro.ambarpastelaria.controller;

import com.pedro.ambarpastelaria.DTO.ProdutoDTO;
import com.pedro.ambarpastelaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController
{
    @Autowired
    private ProdutoService service;



    @PostMapping
    public ProdutoDTO salvar(@RequestBody @Valid ProdutoDTO dto)
    {
        return service.salvar(dto);
    }
    @GetMapping
    public List<ProdutoDTO> listar()
    {
        return service.listar();
    }
    @GetMapping("/{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id)
    {
        return service.buscaPorId(id);
    }

    /*Metodo para atualizar produto. */
    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dto)
    {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    @PatchMapping("/{id}/disponibilidade")
    public ProdutoDTO alterarDisponibilidade(@PathVariable Long id, @RequestParam boolean disponivel){
        return service.alterarDisponibilidade(id, disponivel);
    }
}
