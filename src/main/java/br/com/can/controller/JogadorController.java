package br.com.can.controller;

import br.com.can.entity.Jogador;
import br.com.can.repository.JogadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/jogadores"})
public class JogadorController {

    private JogadorRepository repository;

    JogadorController(JogadorRepository jogadorRepository) {
        this.repository = jogadorRepository;
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
    public Jogador create(@RequestBody Jogador jogador) {
        return repository.save(jogador);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Jogador jogador) {
        return this.repository.findById(id)
                .map(record -> {
                    record.setPosicao(jogador.getPosicao());
                    record.setTotalGols(jogador.getTotalGols());
                    record.setPeso(jogador.getPeso());
                    record.setAltura(jogador.getAltura());
                    Jogador updated = this.repository.save(record);
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
