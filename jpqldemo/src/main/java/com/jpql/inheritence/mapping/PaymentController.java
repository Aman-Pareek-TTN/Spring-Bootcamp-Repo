package com.jpql.inheritence.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping(path = "/addcardpaymentdetails")
    public void addCardPaymentDetails(@RequestBody Card cc){
        paymentService.saveCardPayment(cc);
    }

    @PostMapping(path = "/addcheckpaymentdetails")
    public void addCheckPaymentDetails(@RequestBody Check ch){
        paymentService.saveCheckPayment(ch);
    }
}
