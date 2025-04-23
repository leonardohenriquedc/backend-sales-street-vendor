package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
