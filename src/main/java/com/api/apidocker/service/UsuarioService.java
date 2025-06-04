package com.api.apidocker.service;

import com.api.apidocker.table.Usuario;
import com.api.apidocker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return repository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setTelefone(usuarioAtualizado.getTelefone());
            return repository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado com id " + id));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
