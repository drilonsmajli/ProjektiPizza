package ProjektiPizza.demo.controller;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.exception.CreditCardException;
import ProjektiPizza.demo.service.CreditCardService;
import ProjektiPizza.demo.transport.CreditCardTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public List<CreditCardTransport> getAll(){
        return creditCardService.getAll();
    }

    @GetMapping("/{id}")
    public CreditCardTransport get(@PathVariable String id) throws CreditCardException {
        return creditCardService.get(id);
    }

    @PostMapping
    public CreditCardTransport save(@RequestBody CreditCard creditCard) throws CreditCardException {
        return creditCardService.save(creditCard);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) throws CreditCardException{
        creditCardService.delete(id);
    }

}
