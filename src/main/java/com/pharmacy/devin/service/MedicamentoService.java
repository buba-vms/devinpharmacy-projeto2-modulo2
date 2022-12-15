package com.pharmacy.devin.service;


import com.pharmacy.devin.entity.Medicamento;
import com.pharmacy.devin.repository.MedicamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }

    public ResponseEntity<Medicamento> insert(Medicamento medicamento){
        medicamentoRepository.save(medicamento);
        return new ResponseEntity<Medicamento>(medicamento, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Medicamento>> getMedicamentos() {
        return new ResponseEntity<List<Medicamento>>(medicamentoRepository.findAll(), HttpStatus.OK);
    }


}
