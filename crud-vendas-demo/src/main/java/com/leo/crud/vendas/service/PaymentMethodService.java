package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.PaymentMethodDTO;
import com.leo.crud.vendas.entities.PaymentMethod;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    protected PaymentMethodDTO getMirrorById(Long id){
        Optional<PaymentMethod> result = paymentMethodRepository.findById(id);

        if(result.isPresent()){
            return new PaymentMethodDTO(
                    result.get().getId(),
                    result.get().getMethod()
            );
        }

        throw new ResourceNotFound("Id of Payment Method not found");
    }

    public List<PaymentMethodDTO> getAll(){
        List<PaymentMethod> result = paymentMethodRepository.findAll();

        return result.stream().map(paymentMethod -> new PaymentMethodDTO(
                paymentMethod.getId(),
                paymentMethod.getMethod()
                )
        ).toList();
    }
}
