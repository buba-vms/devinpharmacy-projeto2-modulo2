package com.pharmacy.devin.repository;

import com.pharmacy.devin.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {


}
