package com.pharmacy.devin.service;


import com.pharmacy.devin.controller.dto.respostapadrao.DefaultResponse;
import com.pharmacy.devin.entity.Medicamento;

import com.pharmacy.devin.exception.BadRequestException;
import com.pharmacy.devin.exception.NotFoundException;
import com.pharmacy.devin.repository.MedicamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }


    public ResponseEntity<DefaultResponse<Medicamento>> insert(Medicamento medicamento){
        try {
            medicamentoRepository.save(medicamento);
            return new ResponseEntity<DefaultResponse<Medicamento>>(new DefaultResponse<>(
                    201,
                    "Medicamento Criado",
                    medicamento), HttpStatus.CREATED);
        } catch (Exception e){
            throw new BadRequestException("Body Request Inválida");
        }

    }


    public ResponseEntity<DefaultResponse<List<Medicamento>>> getAllMeds() {
        try {
            return new ResponseEntity<DefaultResponse<List<Medicamento>>>(
                    new DefaultResponse<>(
                            200,
                            "Lista de medicamentos encontrada",
                            medicamentoRepository.findAll()),
                    HttpStatus.OK);
        } catch (Exception e){
            throw new NotFoundException("Lista de medicamentos não encontrada");
        }

    }


    public ResponseEntity<DefaultResponse<Medicamento>> getMedById(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(()-> new NotFoundException("Medicamento de id " + id +" não encontrado"));

        return new ResponseEntity<DefaultResponse<Medicamento>>(new DefaultResponse<>(
                200,
                "Medicamento encontrado",
                medicamento
        ), HttpStatus.OK);
    }


    public ResponseEntity<DefaultResponse<Medicamento>> updateMedById(Long id, Medicamento medicamento) {
        Medicamento entity = medicamentoRepository.findById(id).orElseThrow(()-> new NotFoundException("Medicamento de id " + id +" não encontrado"));

      try {
          entity.setNome(medicamento.getNome());
          entity.setDescricao(medicamento.getDescricao());
          entity.setLaboratorio(medicamento.getLaboratorio());
          entity.setPrecoUnitario(medicamento.getPrecoUnitario());
          entity.setTipo(medicamento.getTipo());
          entity.setDosagem(medicamento.getDosagem());

          return new ResponseEntity<DefaultResponse<Medicamento>>(new DefaultResponse<Medicamento>(
                  202,
                  "Medicamento com id " + id + " atualizado com sucesso",
                  entity),
                  HttpStatus.ACCEPTED);
      } catch (Exception e){
          throw new BadRequestException("Request Body Invalido");
      }

    }


    public ResponseEntity<DefaultResponse<Void>> deleteById(Long id) {
        Medicamento entity = medicamentoRepository.findById(id).orElseThrow(()-> new NotFoundException("Medicamento de id " + id +" não encontrado"));;
        medicamentoRepository.delete(entity);

        return new ResponseEntity<DefaultResponse<Void>>(new DefaultResponse<>(
                400, "Medicamento de id " + id + " deletado com sucesso"),
                HttpStatus.ACCEPTED);
    }

}
