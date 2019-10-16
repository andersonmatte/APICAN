package br.com.can.controller;

import br.com.can.entity.Categoria;
import br.com.can.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/categorias"})
public class CategoriaController {

    private CategoriaRepository repository;

    CategoriaController(CategoriaRepository categoriaRepository) {
        this.repository = categoriaRepository;
    }


    @GetMapping
    public List findAll() {
        return this.repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Categoria categoria) {
        return this.repository.findById(id)
                .map(record -> {
                    record.setTipoCategoria(categoria.getTipoCategoria());
                    Categoria updated = this.repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return this.repository.findById(id)
                .map(record -> {
                    this.repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
