package com.pharmacy.devin.repository;

import com.pharmacy.devin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u.id FROM usuario u WHERE u.email = :email AND u.senha = :senha")
    List<Long> findIdByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

}
