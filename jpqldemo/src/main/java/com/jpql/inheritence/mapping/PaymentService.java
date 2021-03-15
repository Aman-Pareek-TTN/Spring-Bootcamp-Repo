package com.jpql.inheritence.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public void saveCardPayment(Card card){
        paymentRepository.save(card);
    }
    public void saveCheckPayment(Check check){
        paymentRepository.save(check);
    }
}
