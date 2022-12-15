package com.pharmacy.devin.controller;


import com.pharmacy.devin.controller.dto.usuario.UsuarioRequest;
import com.pharmacy.devin.controller.dto.usuario.UsuarioResponse;
import com.pharmacy.devin.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.insert(usuarioRequest);
    }
}
