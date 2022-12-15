package com.pharmacy.devin.controller;


import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {

    private MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> getAll(){
        return medicamentoService.getMedicamentos();
    }


    @PostMapping
    public ResponseEntity<Medicamento> save(@RequestBody Medicamento medicamento){
        return medicamentoService.insert(medicamento);
    }


}
