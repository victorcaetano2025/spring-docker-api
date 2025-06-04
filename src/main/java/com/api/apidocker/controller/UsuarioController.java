package com.api.apidocker.controller;

import com.api.apidocker.service.UsuarioService;
import com.api.apidocker.table.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario salvo = service.salvar(usuario);
        return ResponseEntity.created(URI.create("/usuarios/" + salvo.getId())).body(salvo);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return service.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario atualizado = service.atualizar(id, usuario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
