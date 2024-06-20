package com.example.repository;

import com.example.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    // Método para buscar um usuário pelo nome de usuário
    Usuario findByNomeUsuario(String nomeUsuario);

}
