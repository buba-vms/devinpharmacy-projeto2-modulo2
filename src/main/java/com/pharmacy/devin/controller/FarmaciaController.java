package com.pharmacy.devin.controller;


import com.pharmacy.devin.controller.dto.farmacia.FarmaciaRequest;
import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Farmacia;
import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.service.FarmaciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("farmacias")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;
    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<List<Farmacia>>> getAll(){
        return farmaciaService.getAllFarmacia();
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Farmacia>> getFarmaciaById(@PathVariable Long id){
        return farmaciaService.getFarmaciaById(id);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse<Farmacia>> save(@RequestBody FarmaciaRequest farmaciaRequest){
        return farmaciaService.save(farmaciaRequest);
    }


    @PutMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Farmacia>> updateFarmaciaById(@PathVariable Long id, @RequestBody FarmaciaRequest farmaciaRequest){
        return farmaciaService.updateById(id, farmaciaRequest);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<DefaultResponse<Void>> deleteById(@PathVariable Long id) {
        return farmaciaService.deleteById(id);
    }

}
