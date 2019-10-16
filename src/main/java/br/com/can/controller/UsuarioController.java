package br.com.can.controller;

import br.com.can.entity.Usuario;
import br.com.can.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    private UsuarioRepository repository;

    UsuarioController(UsuarioRepository userRepository) {
        this.repository = userRepository;
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
    public Usuario create(@RequestBody Usuario user) {
        return this.repository.save(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Usuario user) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(user.getNome());
                    record.setDataNascimento(user.getDataNascimento());
                    record.setCpf(user.getCpf());
                    record.setEndereco(user.getEndereco());
                    record.setEmail(user.getEmail());
                    record.setTipoUsuario(user.getTipoUsuario());
                    record.setUsuario(user.getUsuario());
                    record.setSenha(user.getSenha());
                    Usuario updated = repository.save(record);
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

