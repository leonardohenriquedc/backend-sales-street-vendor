package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.PaymentMethodDTO;
import com.leo.crud.vendas.entities.PaymentMethod;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodDTO findById(Long id){
        Optional<PaymentMethod> result = paymentMethodRepository.findById(id);

        if(result.isPresent()){
            return new PaymentMethodDTO(
                    result.get().getId(),
                    result.get().getMethod()
            );
        }

        throw new ResourceNotFound("Id of Payment Method not found");
    }
}
