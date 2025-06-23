package com.demo.cointransfer.repository;

import com.demo.cointransfer.domain.CurrencyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyMapping, String> {
}
