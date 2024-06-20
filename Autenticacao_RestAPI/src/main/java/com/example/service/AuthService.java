package com.example.service;

import com.example.entity.Usuario;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(String userName) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(userName);
        if (usuario != null) {
            String token = JwtUtil.generatedToken(userName);
            return token;
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }

    public String extractUsername(String token) {
        return JwtUtil.extractUsername(token);
    }

    public boolean authenticate(String userName, String senha) {
        Usuario usuario = usuarioRepository.findByNomeUsuario(userName);
        if (usuario != null && passwordEncoder.matches(senha, usuario.getSenha())) {
            return true;
        } else {
            return false;
        }
    }
}
