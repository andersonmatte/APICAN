package br.com.can.controller;

import br.com.can.entity.Clube;
import br.com.can.repository.ClubeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clubes"})
public class ClubeController {

    private ClubeRepository repository;

    ClubeController(ClubeRepository clubeRepository) {
        this.repository = clubeRepository;
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
    public Clube create(@RequestBody Clube clube) {
        return repository.save(clube);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Clube clube) {
        return this.repository.findById(id)
                .map(record -> {
                    record.setDescricao(clube.getDescricao());
                    record.setTelefone(clube.getTelefone());
                    record.setCnpj(clube.getCnpj());
                    record.setRazaoSocial(clube.getRazaoSocial());
                    record.setEmail(clube.getEmail());
                    record.setLinkFace(clube.getLinkFace());
                    record.setLinkInstagran(clube.getLinkInstagran());
                    Clube updated = this.repository.save(record);
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
