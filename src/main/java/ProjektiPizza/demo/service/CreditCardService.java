package ProjektiPizza.demo.service;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.exception.CreditCardException;
import ProjektiPizza.demo.mapper.CreditCardMapper;
import ProjektiPizza.demo.repository.CreditCardRepository;
import ProjektiPizza.demo.transport.CreditCardTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCardTransport> getAll(){
        return creditCardRepository.findAll().stream().map(CreditCardMapper::toTransport).collect(Collectors.toList());
    }

    public CreditCardTransport get(String id) throws CreditCardException {
        if(id == null||id.trim().isEmpty()){
            throw new CreditCardException("Id null");
        }
        final Optional<CreditCard> byId=creditCardRepository.findById(id);
        return CreditCardMapper.toTransport(byId.orElseThrow(() -> new CreditCardException("None CreditCard found")));
    }

    public CreditCardTransport save(CreditCard creditCard) throws CreditCardException{
        if(creditCard == null){
            throw new CreditCardException("CreditCard null");
        }
        return CreditCardMapper.toTransport(creditCardRepository.save(CreditCardMapper.toEntity(creditCard)));
    }

    public void delete(String id) throws CreditCardException {
        if(id == null||id.trim().isEmpty()){
            throw new CreditCardException("Id null");
        }
        creditCardRepository.deleteById(id);
    }

}
