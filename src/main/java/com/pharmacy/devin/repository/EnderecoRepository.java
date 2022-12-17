package com.pharmacy.devin.repository;


import com.pharmacy.devin.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco ,Long> {
}
