package com.example.controller;

import com.example.entity.Usuario;
import com.example.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<Object> salvarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = usuarioService.cadastraUsuario(
                    usuario.getId(),
                    usuario.getNomeUsuario(),
                    usuario.getSenha(),
                    usuario.getEmail(),
                    usuario.getTipoConta().ordinal() + 1 // Assumindo que os valores de enum começam de 0
            );
            return ResponseEntity.ok(novoUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Object> deletarUsuario(@RequestParam("idUsuario") String idUsuario) {
        try {
            return ResponseEntity.ok(usuarioService.deletarUsuario(idUsuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/obtemTodos")
    public ResponseEntity<Object> obtemTodos() {
        try {
            return ResponseEntity.ok(usuarioService.obtemTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/obtemUsuarioPorId")
    public ResponseEntity<Object> obtemUsuarioPorId(@RequestParam("idUsuario") String idUsuario) {
        try {
            return ResponseEntity.ok(usuarioService.findUsuarioById(idUsuario));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }
}
