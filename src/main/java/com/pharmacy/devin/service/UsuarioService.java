package com.pharmacy.devin.service;

import com.pharmacy.devin.controller.dto.usuario.UsuarioIdResponse;
import com.pharmacy.devin.controller.dto.usuario.UsuarioRequest;
import com.pharmacy.devin.controller.dto.usuario.UsuarioResponse;
import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.entity.Usuario;
import com.pharmacy.devin.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<UsuarioResponse> insert(UsuarioRequest usuarioRequest){
        Usuario entity = new Usuario(usuarioRequest.getEmail(), usuarioRequest.getSenha());
        UsuarioResponse response = new UsuarioResponse(usuarioRequest.getEmail());
        usuarioRepository.save(entity);

        return new ResponseEntity<UsuarioResponse>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<UsuarioIdResponse> getUserId(UsuarioRequest usuarioRequest) {
        String email = usuarioRequest.getEmail();
        String senha = usuarioRequest.getSenha();

        UsuarioIdResponse userId = new UsuarioIdResponse(usuarioRepository.findIdByEmailAndSenha(email, senha));

        return new ResponseEntity<UsuarioIdResponse>(userId, HttpStatus.OK);
    }
}
