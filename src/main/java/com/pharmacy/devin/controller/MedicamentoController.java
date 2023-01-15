package com.pharmacy.devin.controller;


import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    private MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<Medicamento>>> getAll(){
        return medicamentoService.getAllMeds();
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Medicamento>> getMedById(@PathVariable Long id){
        return medicamentoService.getMedById(id);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse<Medicamento>> save(@RequestBody Medicamento medicamento){
        return medicamentoService.insert(medicamento);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Medicamento>> updateMedById(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        return medicamentoService.updateMedById(id, medicamento);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Void>> deleteById(@PathVariable Long id) {
        return medicamentoService.deleteById(id);
    }



}
