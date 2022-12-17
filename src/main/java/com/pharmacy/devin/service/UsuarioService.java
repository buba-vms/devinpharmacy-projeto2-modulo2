package com.pharmacy.devin.service;

import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
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

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<DefaultResponse<UsuarioResponse>> insert(UsuarioRequest usuarioRequest){
        Usuario entity = new Usuario(usuarioRequest.getEmail(), usuarioRequest.getSenha());
        UsuarioResponse response = new UsuarioResponse(usuarioRequest.getEmail());
        usuarioRepository.save(entity);

        return new ResponseEntity<DefaultResponse<UsuarioResponse>>(new DefaultResponse<UsuarioResponse>(
                201,
                "Usuario " + usuarioRequest.getEmail() + " criado com sucesso",
                response), HttpStatus.CREATED);
    }

    public ResponseEntity<DefaultResponse<UsuarioIdResponse>>getUserId(UsuarioRequest usuarioRequest) {
        String email = usuarioRequest.getEmail();
        String senha = usuarioRequest.getSenha();

        UsuarioIdResponse userId = new UsuarioIdResponse(usuarioRepository.findIdByEmailAndSenha(email, senha));

        return new ResponseEntity<DefaultResponse<UsuarioIdResponse>>(new DefaultResponse<UsuarioIdResponse>(
                200,
                "usuario encontrado com sucesso",
                userId),
                HttpStatus.OK);
    }
}
