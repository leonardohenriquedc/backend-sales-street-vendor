package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
