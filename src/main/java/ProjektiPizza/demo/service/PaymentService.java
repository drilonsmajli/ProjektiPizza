package ProjektiPizza.demo.service;
import ProjektiPizza.demo.entity.CreditCard;
import ProjektiPizza.demo.entity.Payment;
import ProjektiPizza.demo.entity.Pizza;
import ProjektiPizza.demo.entity.User;
import ProjektiPizza.demo.exception.PizzaException;
import ProjektiPizza.demo.repository.PaymentRepository;
import ProjektiPizza.demo.transport.CreditCardTransport;
import ProjektiPizza.demo.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    UserService userService;

    public Payment getPaymentStatus(String payWith,CreditCard card,long id) throws Exception {
        if (pizzaService.getPizza() == null) {
            throw new Exception("No pizza found");
        }
        Payment payment=new Payment();
        CreditCard creditCard=new CreditCard();
        User user=new User();
        for(Pizza p:pizzaService.getPizza()){
            if(p.getId()==id){
                for(CreditCardTransport creditCardTransport:creditCardService.getAll()){
                    if(creditCardTransport.getNrCc()==card.getNrCc() && card.getBalance() >= p.getPrice()) {
                        if(p.getPrice()>card.getBalance()) {
                            throw new PizzaException("Ska vllaqko");
                        }
                        card.setBalance(card.getBalance()-p.getPrice());
                        for(UserTransport userTransport:userService.getAll()){
                            if (userTransport.getCreditCard().equals(card)) {
                                user.setFullName(userTransport.getFullName());
                                user.setUsername(userTransport.getUsername());
                                user.setPassword(userTransport.getPassword());
                                user.setPayment(userTransport.getPayment());
                                userTransport.getCreditCard().add(creditCard);
                                user.setCreditCard(userTransport.getCreditCard());
                                creditCard.setNrCc(creditCardTransport.getNrCc());
                                creditCard.setId(creditCardTransport.getId());
                                creditCard.setCcv(creditCardTransport.getCcv());
                                creditCard.setExpDd(creditCardTransport.getExpDd());
                                creditCard.setBalance(creditCardTransport.getBalance());
                                creditCard.setPayment(creditCardTransport.getPayment());
                                creditCard.setUser(user);
                                payment.setId(payment.getId());
                                payment.setStatus(true);
                                payment.getPizza().add(p);
                                p.setPayment(payment);
                                payment.setCreditCard(creditCard);
                                payment.setUser(user);
                                return paymentRepository.save(payment);
                            }
                        }
                    }
                }
            }
        }
        return paymentRepository.save(payment);
    }
}
