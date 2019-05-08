package ProjektiPizza.demo.mapper;

import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.exception.CreditCardException;
import ProjektiPizza.demo.transport.CreditCardTransport;

public class CreditCardMapper {

    public static CreditCardTransport toTransport(CreditCard creditCard){
        if(creditCard == null){
            return null;
        }

        CreditCardTransport creditCardTransport=new CreditCardTransport();
        creditCardTransport.setId(creditCard.getId());
        creditCardTransport.setNrCc(creditCard.getNrCc());
        creditCardTransport.setCcv(creditCard.getCcv());
        creditCardTransport.setExpDd(creditCard.getExpDd());
        creditCardTransport.setBalance(creditCard.getBalance());
        creditCardTransport.setPayment(creditCard.getPayment());
        creditCardTransport.setUser(creditCard.getUser());

        return  creditCardTransport;
    }

    public static CreditCard toEntity(CreditCard creditCard){
        if(creditCard == null){
            return null;
        }
        CreditCard creditCard1=new CreditCard();
        creditCard1.setId(creditCard.getId());
        creditCard1.setNrCc(creditCard.getNrCc());
        creditCard1.setExpDd(creditCard.getExpDd());
        creditCard1.setCcv(creditCard.getCcv());
        creditCard1.setBalance(creditCard.getBalance());
        creditCard1.setPayment(creditCard.getPayment());
        creditCard1.setUser(creditCard.getUser());

        return creditCard;
    }
}
