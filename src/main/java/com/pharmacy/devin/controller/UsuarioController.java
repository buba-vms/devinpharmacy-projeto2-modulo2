package com.pharmacy.devin.controller;


import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.controller.dto.usuario.UsuarioIdResponse;
import com.pharmacy.devin.controller.dto.usuario.UsuarioRequest;
import com.pharmacy.devin.controller.dto.usuario.UsuarioResponse;
import com.pharmacy.devin.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }




    @PostMapping("cadastro")
    public ResponseEntity<DefaultResponse<UsuarioResponse>> save(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.insert(usuarioRequest);
    }

    @GetMapping("login")
    public ResponseEntity<DefaultResponse<UsuarioIdResponse>> getUserId(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.getUserId(usuarioRequest);
    }



}
