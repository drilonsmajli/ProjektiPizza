package ProjektiPizza.demo.controller;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.entity.Payment;
import ProjektiPizza.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{payWith}/{id}")
    public Payment getPaymentStatus(String payWith, @RequestBody CreditCard card,@PathVariable long id) throws Exception {
        return paymentService.getPaymentStatus(payWith,card,id);
    }
}
