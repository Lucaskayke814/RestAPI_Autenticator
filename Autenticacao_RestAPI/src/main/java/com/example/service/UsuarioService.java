package com.example.service;

import com.example.entity.Usuario;
import com.example.enums.TipoConta;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastraUsuario(String id, String nomeUsuario, String senha, String email, long identificadorTipoUsuario) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setEmail(email);

        if (identificadorTipoUsuario == 1L) {
            usuario.setTipoConta(TipoConta.USER);
        } else if (identificadorTipoUsuario == 2L) {
            usuario.setTipoConta(TipoConta.MOD);
        } else if (identificadorTipoUsuario == 3L) {
            usuario.setTipoConta(TipoConta.ADMIN);
        } else {
            throw new Exception("Forneça o tipo de usuário correto. (1- COMUM, 2 - MODERADOR, 3 - ADMIN)");
        }

        return this.salvarUsuario(usuario);
    }

    private Usuario salvarUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public String deletarUsuario(String idUsuario) {
        Usuario usuario = this.findUsuarioById(idUsuario);
        this.usuarioRepository.delete(usuario);
        return "Usuario deletado";
    }

    public List<Usuario> obtemTodos() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findUsuarioById(String idUsuario) {
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }
}
