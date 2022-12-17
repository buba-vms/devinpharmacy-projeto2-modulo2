package com.pharmacy.devin.controller;


import com.pharmacy.devin.controller.dto.farmacia.FarmaciaRequest;
import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Farmacia;
import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.service.FarmaciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmacias")
public class FarmaciaController {

    private FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponse<Farmacia>> save(@RequestBody FarmaciaRequest farmaciaRequest){
        return farmaciaService.save(farmaciaRequest);
    }
}
