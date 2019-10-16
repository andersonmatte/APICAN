package br.com.can.controller;

import br.com.can.entity.Jogo;
import br.com.can.repository.JogoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/jogos"})
public class JogoController {

    private JogoRepository repository;

    JogoController(JogoRepository jogoRepository) {
        this.repository = jogoRepository;
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
    public Jogo create(@RequestBody Jogo jogo) {
        return repository.save(jogo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Jogo jogo) {
        return this.repository.findById(id)
                .map(record -> {
                    record.setDataJogo(jogo.getDataJogo());
                    record.setLocal(jogo.getLocal());
                    record.setMandante(jogo.getMandante());
                    record.setVisitante(jogo.getVisitante());
                    record.setGolsMandante(jogo.getGolsMandante());
                    record.setGolsVisitante(jogo.getGolsVisitante());
                    Jogo updated = this.repository.save(record);
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
