package com.cooperativaapi.repository;

import com.cooperativaapi.model.Dividendo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendoRepository extends JpaRepository<Dividendo, Long> {
}
