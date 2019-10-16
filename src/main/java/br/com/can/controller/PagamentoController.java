package br.com.can.controller;

import br.com.can.entity.Pagamento;
import br.com.can.repository.PagamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/pagamentos"})
public class PagamentoController {

    private PagamentoRepository repository;

    PagamentoController(PagamentoRepository pagamentoRepository) {
        this.repository = pagamentoRepository;
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
    public Pagamento create(@RequestBody Pagamento pagamento) {
        return repository.save(pagamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Pagamento pagamento) {
        return this.repository.findById(id)
                .map(record -> {
                    record.setDataPagamento(pagamento.getDataPagamento());
                    record.setValor(pagamento.getValor());
                    Pagamento updated = this.repository.save(record);
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
